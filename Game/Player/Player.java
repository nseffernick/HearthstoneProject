package Game.Player;

import Cards.Card;
import Cards.Minion;
import Cards.Spell;
import Game.Player.HeroPowers.HeroPower;
import Utility.UtilityMethods.hsCeption;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * The player's internal settings like the name, fatigue,
 * and spell damage would be included with the player.
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
    private int spellDamage; // How much spell damage is on the board
    private LinkedList<Minion> playerSide;
    private LinkedList<Card> deck;
    private LinkedList<Card> hand;
    private Hero hero;
    private int fatigue;
    private hsCeption rng;
    private HeroPower heroPower;
    private int side;
    // private AI type;

    /**
     * Constructor - only needs to take in what the player gives in the
     * actual game.
     * @param decklist
     * @param Hero
     */
    public Player(String decklist, String Hero, int side) {
        this.mana = STARTING_MANA;
        this.hero = new Hero(Hero, this);
        this.playerSide = new LinkedList<>();
        this.deck = initializeDeck(decklist);
        rng = new hsCeption();
        this.side = side;
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

    public LinkedList<Minion> getPlayerSide() {
        return playerSide;
    }

    /*
    Deck and hand will probably have test display methods
     */
    public LinkedList<Card> getDeck() {
        return deck;
    }

    public LinkedList<Card> getHand() {
        return hand;
    }

    public Hero getHero() {
        return hero;
    }

    public hsCeption getRng() {
        return rng;
    }

    public int getSpellDamage() {
        return spellDamage;
    }

    public HeroPower getHeroPower() {
        return heroPower;
    }

    public void setHeroPower(HeroPower heroPower) {
        this.heroPower = heroPower;
    }

    public void addMana(int set) {
        mana += set;
    }

    /**
     * Runs the mulligan phase
     * @param position - is the player first or second
     */
    public void mulligan(String position) {
        Scanner chooseCard = new Scanner(System.in);
        int i = 0;
        int drawMore = 0;
        if (position.equals("first")) {
            System.out.println("You are going first.");
            drawCard();
            drawCard();
            drawCard();
            System.out.println("Choose which cards to put back in your deck.");
            for (Card card: hand) {
                if (mulliganHelper(card, chooseCard)) {
                    deck.add(hand.remove(i));
                    drawMore += 1;
                }
                i += 1;
            }
            while (drawMore > 0){
                drawCard();
                drawMore -= 1;
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
                    drawMore += 1;
                }
                i += 1;
            }
            while (drawMore > 0){
                drawCard();
                drawMore -= 1;
            }
            rng.shuffle(this.deck);
        }
    }

    /**
     *
     * @param card
     * @param choose
     * @return
     */
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
     * not sure what this will do
     * @return
     */
    public boolean endTurn() {
        return true;
    }

    /**
     * Pre-Condition gives a correct index
     * Very rough, will definitely need to update
     *
     * A player cannot play a minion if the board space will be full when summoned
     * @param card - card player is playing from hand
     */
    public void playCard(Card card, int index) {
        if (playerSide.size() < BOARD_SLOTS) {
            hand.remove(card);
            // If card is a minion
            if (card instanceof Minion) {
                Minion minion = (Minion)(card);
                if (playerSide.isEmpty()) {
                    playerSide.add(minion);
                }
                else playerSide.add(index, minion);
            }
            // If card is a spell
            else if (card instanceof Spell) {

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

    /**
     * Casts heropower
     * @param player
     * @param index
     */
    public void heroPower(Player player, int index) {
        heroPower.Cast(player, index);
    }


}