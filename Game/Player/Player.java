package Game.Player;

import Cards.Structure.Card;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.Auras.Aura;
import Game.BoardState;
import Game.Player.HeroPowers.HeroPower;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.Keywords.Keywords;
import Utility.UtilityMethods.hsCeption;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

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
    private int fatigue;
    private HeroPower heroPower;
    private Hero hero;
    private hsCeption rng;
    private String name;
    private Scanner playerInput;
    private LinkedList<Minion> playerSide;
    private LinkedList<Card> deck;
    private LinkedList<Card> hand;
    private LinkedList<Card> graveyard;
    private LinkedList<Aura> auras;

    /**
     * Constructor - only needs to take in what the player gives in the
     * actual game.
     * @param decklist
     * @param Hero
     */
    public Player(String decklist, String Hero, String name) {
        this.manaCyrstals = STARTING_MANA;
        this.mana = STARTING_MANA;
        this.name = name;
        this.hero = new Hero(Hero, this);
        this.rng = new hsCeption();
        this.playerSide = new LinkedList<Minion>();
        this.hand = new LinkedList<Card>();
        this.graveyard = new LinkedList<Card>();
        this.auras = new LinkedList<Aura>();
        this.deck = initializeDeck(decklist);
        this.playerInput = new Scanner(System.in);
        rng.shuffle(deck);
    }

    /**
     * Initializes deck
     * @param decklist
     * @return
     */
    private LinkedList<Card> initializeDeck(String decklist) {
        LinkedList<Card> deck = new LinkedList<>();
        String[] decklistArr = decklist.split(" ");
        for (String card : decklistArr) {
            try {
                /////////////////////////////////////////////////////////////////
                // WHY HAS NO ONE TOLD ME ABOUT THIS                           //
                Class newCard = Class.forName(card);                           //
                Constructor constructor = newCard.getConstructor(Player.class);//
                Object card1 = constructor.newInstance(this);         //
                // This is the only code that matters in this entire program   //
                /////////////////////////////////////////////////////////////////
                if (card1 instanceof Card) {
                    Card card2 = (Card) (card1);
                    deck.add(card2);
                }
            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException
                    | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
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

    public Scanner getPlayerInput() {
        return playerInput;
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

    public LinkedList<Minion> getPlayerSide() {
        return playerSide;
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

    public LinkedList<Aura> getAuras() { return auras;};

    public void setHeroPower(HeroPower heroPower) {
        this.heroPower = heroPower;
    }

    public void addMana(int set) {
        mana += set;
    }

    public void addManaCrystals(int set) { manaCyrstals += set; }

    /**
     * Runs the mulligan phase
     * @param position - is the player first or second
     */
    public void mulligan(String position, BoardState board) {

        Scanner chooseCard = new Scanner(System.in);
        int i = 0;
        int mullCount = 0;

        if (position.equals("first")) {
            System.out.println("You are going first.");
            drawCard(board);
            drawCard(board);
            drawCard(board);
            System.out.println("Choose which cards to put back in your deck.");
            for (Card card: hand) {
                if (mulliganHelper(card, chooseCard)) {
                    deck.add(hand.remove(i));
                    mullCount += 1;
                }
                i += 1;
            }
            while (mullCount > 0){
                drawCard(board);
                mullCount -= 1;
            }
            rng.shuffle(this.deck);
        }

        else {
            System.out.println("You are going second.");
            drawCard(board);
            drawCard(board);
            drawCard(board);
            drawCard(board);
            System.out.println("Choose which cards to put back in your deck.");
            for (Card card: hand) {
                if (mulliganHelper(card, chooseCard)) {
                    deck.add(hand.remove(i));
                    mullCount += 1;
                }
                i += 1;
            }
            while (mullCount > 0){
                drawCard(board);
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

    private void applyAura(Aura aura, BoardState board) {

        LinkedList<Card> where = determineWhere(aura, board);
        String[] text = aura.getEffect().split(" ");
        int increment = getIncrement(text);
        modifyWhere(where, text, increment, board);
    }

    private LinkedList<Card> determineWhere(Aura aura, BoardState board) {

        String[] text = aura.getWhere().split(" ");

        Player player;
        if (text[0].equals("Friendly")) {
            player = this;
        }
        else if (text[0].equals("Enemy")) {
            player = board.findEnemy(this);
        }
        else player = null;

        return MasterTargeter.CustomTarget(player,text[1], aura.getTribe(), aura.getLink());
    }

    private void modifyWhere(LinkedList<Card> where, String[] text, int increment, BoardState board) {

        for (Card card: where) {
            if(text[0].equals("Attack")) {
                if (card instanceof Minion) {
                    Minion minion =(Minion)card;
                    minion.addAtk(increment);
                }
            }
            else if(text[0].equals("Health")) {
                if (card instanceof Minion) {
                    Minion minion = (Minion) card;
                    minion.addMaxHP(increment);
                    minion.addHp(increment, board);
                }
            }
            else if(text[0].equals("Attack/Health")) {
                if (card instanceof Minion) {
                    Minion minion = (Minion) card;
                    minion.addMaxHP(increment);
                    minion.addHp(increment, board);
                    minion.addAtk(increment);
                }
            }
            else if(text[0].equals("Cost")) {
                card.addCost(increment);
            }
        }

    }

    private int getIncrement(String[] text) {
        int increment = Integer.parseInt(text[2]);
        if(text[1].charAt(0) ==  '-') {
            increment = increment - (2*increment);
        }
        return increment;
    }

    public void removeAura(Aura aura, BoardState board) {
        if (checkForAura(aura));
        else {
            LinkedList<Card> where = determineWhere(aura, board);
            String[] text = aura.getEffect().split(" ");
            int increment = getIncrement(text);
            increment = increment - (2*increment);
            modifyWhere(where, text, increment, board);
        }
    }

    private boolean checkForAura(Aura aura) {
        return !aura.getLink().isDead() && aura.getLink().getProperties().contains(Keywords.AURA);
    }

    public void addAura(Aura aura, BoardState board) {
        auras.add(aura);
        applyAura(aura, board);
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
                minion.getProperties().add(Keywords.SUMMONSICKNESS);
                minion.createAura(board);
                minion.battlecry(board, this, promptTargetIndex(board));
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

    private int promptTargetIndex(BoardState board) {

        if (playerInput.hasNext()) {
            board.peekYourHand(this);
            board.peekBoard(this);
            System.out.println("What index would you like to target:");
            System.out.print("> ");
            int battlecryIndex = playerInput.nextInt();
            return battlecryIndex;
        }
        return 0;
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
    public void drawCard(BoardState board) {

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
     */
    public void heroPower(Player player, BoardState board) {
        heroPower.Cast(player, promptTargetIndex(board), board);
    }

    public void checkBoardForDead() {
        for (Iterator<Minion> iter = playerSide.iterator(); iter.hasNext(); ) {
            Minion minion = iter.next();
            if (minion.isDead()) {
                placeCardInGraveyard(minion);
            }
        }
    }

    public void placeCardInGraveyard(Card card) {
        if (card instanceof Minion) {
            Minion minion = (Minion) card;
            playerSide.remove(minion);
            Class newMinion = minion.getClass();
            try {
                Constructor constructor = newMinion.getConstructor(Player.class);
                Object card1 = constructor.newInstance(this);
                if (card1 instanceof Card) {
                    Card card2 = (Card) (card1);
                    graveyard.add(card2);
                }
            }
            catch (InstantiationException | InvocationTargetException | IllegalAccessException |  NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    public static void Main() {

        //Player player1 = new Player(, "Paladin", "CheechX2")
    }
}