package Game.Player;

import Cards.Card;
import Cards.Minion;
import Cards.Spell;
import Game.BoardState;
import Game.Player.HeroPowers.HeroPower;
import Utility.Keywords.Keywords;
import Utility.UtilityMethods.hsCeption;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import static sun.audio.AudioPlayer.player;

/**
 * The player's internal settings like the name, fatigue.
 * Ultimately responsible for everything that it can do with cards
 * and mana while rest is delegated to the hero
 */
public class Player {

    // CONSTANTS
    private final int STARTING_MANA = 0;
    private final int BOARD_SLOTS = 7;
    private final int MAX_HAND_SIZE = 10;

    // State
    private int manaCyrstals; // Max mana
    private int mana; // Current mana
    private LinkedList<Minion> playerSide;
    private LinkedList<Card> deck;
    private LinkedList<Card> hand;
    private LinkedList<Card> graveyard;
    private Hero hero;
    private int fatigue;
    private hsCeption rng;
    private HeroPower heroPower;
    private String name;
    private Scanner playerInput;
    private BoardState board;
    // private AI type;

    /**
     * Constructor - only needs to take in what the player gives in the
     * actual game.
     * @param decklist
     * @param Hero
     */
    public Player(String decklist, String Hero, String name, BoardState board) {
        this.manaCyrstals = STARTING_MANA;
        this.mana = STARTING_MANA;
        this.name = name;
        this.hero = new Hero(Hero, this);
        this.playerSide = new LinkedList<Minion>();
        this.hand = new LinkedList<Card>();
        this.graveyard = new LinkedList<Card>();
        rng = new hsCeption();
        this.board = board;
        this.deck = initializeDeck(decklist);
        this.playerInput = new Scanner(System.in);
    }

    /**
     * Initializes deck
     * @param decklist
     * @return
     */
    private LinkedList<Card> initializeDeck(String decklist) {
        LinkedList<Card> deck = new LinkedList<>();
        String[] decklistArr = decklist.split(" ");
        for (String card: decklistArr) {
            try {
                // WHY HAS NO ONE TOLD ME ABOUT THIS
                Object newCard = Class.forName(card);
                deck.add(((Card)newCard));
            }
            catch (ClassNotFoundException e) {
                System.out.println("This is not a card!");
                e.printStackTrace();
            }
        }
        rng.shuffle(this.deck);
        return deck;
    }

    /*
    Various getters and setters
     */
    public int getManaCyrstals() {
        return manaCyrstals;
    }

    public int getMana() {
        return mana;
    }

    public int getFatigue() {
        return fatigue;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Minion> getPlayerSide() {
        return playerSide;
    }

    public Scanner getPlayerInput() {
        return playerInput;
    }

    public LinkedList<Card> getDeck() {
        return deck;
    }

    public LinkedList<Card> getHand() {
        return hand;
    }

    public LinkedList<Card> getGraveyard() {
        return graveyard;
    }

    public Hero getHero() {
        return hero;
    }

    public HeroPower getHeroPower() {
        return heroPower;
    }

    public hsCeption getRng() {
        return rng;
    }

    public void setHeroPower(HeroPower heroPower) {
        this.heroPower = heroPower;
    }

    public void addMana(int set) {
        mana += set;
    }

    public void addManaCrystals(int set) { manaCyrstals += set; }

    public void addToGraveyard(Card card) {
        graveyard.add(card);
    }

    /**
     * Runs the mulligan phase
     * @param position - is the player first or second
     */
    public void mulligan(String position) {

        Scanner chooseCard = new Scanner(System.in);
        int i = 0;
        int mullCount = 0;

        if (position.equals("first")) {
            System.out.println("You are going first.");
            drawCard();
            drawCard();
            drawCard();
            System.out.println("Choose which cards to put back in your deck.");
            for (Card card: hand) {
                if (mulliganHelper(card, chooseCard)) {
                    deck.add(hand.remove(i));
                    mullCount += 1;
                }
                i += 1;
            }
            while (mullCount > 0){
                drawCard();
                mullCount -= 1;
            }
            rng.shuffle(this.deck);
        }

        else {
            System.out.println("You are going second.");
            drawCard();
            drawCard();
            drawCard();
            drawCard();
            System.out.println("Choose which cards to put back in your deck.");
            for (Card card: hand) {
                if (mulliganHelper(card, chooseCard)) {
                    deck.add(hand.remove(i));
                    mullCount += 1;
                }
                i += 1;
            }
            while (mullCount > 0){
                drawCard();
                mullCount -= 1;
            }
            rng.shuffle(this.deck);
        }
    }

    private boolean mulliganHelper(Card card, Scanner choose) {
        System.out.println("Mull back " + card + "?  (Y/N)");
        if (choose.next().equals("Y") || choose.next().equals("y")) {
            return true;
        }
        else if (choose.next().equals("N") || choose.next().equals("n")) {
            return false;
        }
        System.out.println("Use correct response next time.");
        return false;
    }

    /**
     * Pre-Condition gives a correct index
     * Very rough, will definitely need to update
     *
     * A player cannot play a minion if the board space will be full when summoned
     * @param card - card player is playing from hand
     */
    public void playCard(Card card, int index, BoardState board) {

        if (playerSide.size() < BOARD_SLOTS) {
            hand.remove(card);
            // If card is a minion
            if (card instanceof Minion) {
                Minion minion = (Minion)(card);
                minion.createAura(board);
                minion.battlecry(board, this, 0);
                checkBoardForDead();
                if (playerSide.isEmpty()) {
                    playerSide.add(minion);
                }
                else playerSide.add(index, minion);
            }
            // If card is a spell
            else if (card instanceof Spell) {
                Spell spell = (Spell)(card);
            }
        }
    }

    /**
     * Many things in the game summon minions, playing cards, on board
     * effects, spells.
     * Needs to account for board space even when not playing a card
     * @param minion
     */
    public void summonCard(Minion minion) {
        if (playerSide.size() < BOARD_SLOTS) {
            playerSide.add(minion);
        }
    }

    /**
     * Draws card from deck
     * Accounts for max hand size of 10
     */
    public void drawCard() {

        if (!deck.isEmpty()) {
            Card card = deck.remove();
            if (hand.size() < MAX_HAND_SIZE) {
                hand.add(card);
            }
            else {
                System.out.println(card + " was burned!");
            }
        }
        else {
            fatigue += 1;
            hero.addHp(-fatigue);
        }
    }

    public void concede() {

        System.out.println("Well fought, I concede");
        System.out.println(name + " concedes!");
        int hpLeft = hero.getArmor() + hero.getHp();
        hero.addHp(-hpLeft);
    }

    /**
     * Casts heropower
     * @param player
     * @param index
     */
    public void heroPower(Player player, int index) {
        heroPower.Cast(player, index);
    }

    public void checkBoardForDead() {
        for (Iterator<Minion> iter = playerSide.iterator(); iter.hasNext(); ) {
            Minion minion = iter.next();
            if (minion.isDead()) {
                addToGraveyard(minion);
                playerSide.remove(minion);
            }
        }
    }
}