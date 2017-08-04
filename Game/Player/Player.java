package Game.Player;

import Cards.Structure.Card;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Cards.Structure.Weapon;
import Game.Auras.Aura;
import Game.BoardState;
import Game.Player.HeroPowers.HeroPower;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.Keywords.Keywords;
import Utility.UtilityMethods.UtilityMethods;
import Utility.UtilityMethods.hsCeption;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
    private int manaCrystals; // Max mana
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
        this.manaCrystals = STARTING_MANA;
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
                Constructor<Player> constructor = newCard.getConstructor(Player.class);//
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
    public int getManaCrystals() {
        return manaCrystals;
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

    public void addManaCrystals(int set) { manaCrystals += set; }

    /**
     * Runs the mulligan phase
     */
    public void mulligan(Player player, BoardState board) {

        Scanner chooseCard = playerInput;

        int i = 0;
        int pos = 0;
        int mullCount = 0;

        if (player == board.getP1()) {
            int[] intArr = {12, 21, 23};
            System.out.println("You are going first.");
            drawCard();
            drawCard();
            drawCard();
            System.out.println("Choose which cards to put back in your deck.");
            System.out.println();
            while (pos < hand.size()) {
                String answer = mulliganHelper(this, chooseCard);
                if (answer.equals("Y")) {
                    mullCount += 1;
                    intArr[pos] = i;
                }
                else if (answer.equals("N")) {
                    intArr[pos] = -1;
                    i += 1;
                }
                pos += 1;
            }
            while (mullCount > 0){
                drawCard();
                mullCount -= 1;
            }
            pos = 0;
            while (intArr.length > pos) {
                if (intArr[pos] == -1);
                else {
                    Card card = hand.remove(intArr[pos]);
                    deck.add(card);
                }
                pos += 1;
            }
            rng.shuffle(this.deck);
            System.out.println(hand);
        }

        else {
            int[] intArr = {12, 21, 23, 232};
            System.out.println("You are going second.");
            drawCard();
            drawCard();
            drawCard();
            drawCard();
            System.out.println("Choose which cards to put back in your deck.");
            System.out.println();
            while (pos < hand.size()) {
                String answer = mulliganHelper(this, chooseCard);
                if (answer.equals("Y")) {
                    mullCount += 1;
                    intArr[pos] = i;
                }
                else if (answer.equals("N")) {
                    intArr[pos] = -1;
                    i += 1;
                }
                pos += 1;
            }
            while (mullCount > 0){
                drawCard();
                mullCount -= 1;
            }
            pos = 0;
            while (intArr.length > pos) {
                if (intArr[pos] == -1);
                else {
                    Card card = hand.remove(intArr[pos]);
                    deck.add(card);
                }
                pos += 1;
            }
            rng.shuffle(this.deck);
            System.out.println(hand);
        }
    }

    private String mulliganHelper(Player player, Scanner choose) {
        System.out.println("Mull back the cards with answers in order of what they are shown:\n" +
                "Ex: 'Y' <press enter> means you mull back the first card,\n'N' <press enter> after that means you " +
                "keep the second card and so on and so forth.\n(Y/N are valid responses)");
        System.out.println();
        for (Card card: player.getHand()) {
            System.out.println(card);
        }
        System.out.println();
        return choose.next();
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
            player = UtilityMethods.findEnemy(board, this);
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

        if (!(card.getCost() > mana)) {
            if (playerSide.size() < BOARD_SLOTS) {
                hand.remove(card);
                updateCardCostFromHand();
                // If card is a minion
                if (card instanceof Minion) {
                    Minion minion = (Minion) (card);
                    minion.getProperties().add(Keywords.SUMMONSICKNESS);
                    minion.battlecry(board, this);
                    //TODO The board mechanix!
                    if (playerSide.isEmpty()) {
                        playerSide.add(minion);
                    }
                    else playerSide.add(minion);
                    addMana(-card.getCost());
                    minion.createAura(board);
                    updateCardCostFromBoard(board);
                    procFromCardPlayed(minion, board);
                    procFromMinionSummoned(minion, board);
                    checkBoardForDead(board);
                }
                // If card is a spell
                else if (card instanceof Spell) {
                    Spell spell = (Spell) (card);
                }
                // If card is a weapon
                else if (card instanceof Weapon) {
                    Weapon weapon = (Weapon) (card);
                }
            }
        }
        else {
            System.out.println("You do not have enough mana to cast: " + card.getName());
        }
    }

    /**
     * Many things in the game summon minions, playing cards, on board
     * effects, spells.
     * Needs to account for board space even when not playing a card
     * @param minion
     * @param board
     */
    public void summonCard(Minion minion, BoardState board) {
        if (playerSide.size() < BOARD_SLOTS) {
            minion.getProperties().add(Keywords.SUMMONSICKNESS);
            minion.createAura(board);
            playerSide.add(minion);
            updateCardCostFromBoard(board);
            procFromMinionSummoned(minion, board);
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
                updateCardCostFromHand();
            }
            else {
                System.out.println(card + " was burned!");
            }
        }
        else {
            fatigue += 1;
            hero.addHp(this, -fatigue);
        }
    }

    public void checkBoardForDead(BoardState board) {
        for (Minion minion : playerSide) {
            if (minion.isDead()) {
                placeCardInGraveyard(minion, board);
            }
        }
    }

    public void placeCardInGraveyard(Card card, BoardState board) {
        if (card instanceof Minion) {
            Minion minion = (Minion) card;
            playerSide.remove(minion);
            updateCardCostFromBoard(board);
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

    private void updateCardCostFromBoard(BoardState board) {
        for (Card card: hand) {
            card.updateCostFromBoardSize(board);
        }
        for (Card card: UtilityMethods.findEnemy(board, this).getHand()) {
            card.updateCostFromBoardSize(board);
        }
    }

    private void updateCardCostFromHand() {
        for (Card cardsInHand: hand) {
            cardsInHand.updateCostFromHandSize();
        }
    }

    private void procFromCardPlayed(Card card, BoardState board) {
        for (Minion minion: playerSide) {
            minion.cardPlayedProc(card, board);
        }
    }

    private void procFromMinionSummoned(Minion minion, BoardState board) {
        for (Minion minion1: playerSide) {
            minion1.cardPlayedProc(minion, board);
        }
    }

    public void discard(Card card) {
        hand.remove(card);
        System.out.println(name + " discarded " + card.getName() + "!");
    }

    public Player promptTargetPlayer(BoardState board) {
        System.out.println("Will your target be the enemy, " + UtilityMethods.findEnemy(board, this).name +
        ", or yourself");
        System.out.println("Valid Responses are 'me' and 'enemy'");
        System.out.print(">");
        String aString = playerInput.next("(me)|(enemy)");
        System.out.println();
        Player targetPlayer;
        if (aString.equals("me")) {
            targetPlayer = this;
        }
        else {
            targetPlayer = UtilityMethods.findEnemy(board, this);
        }
        return targetPlayer;
    }

    public int promptTargetIndex(BoardState board, int targetType) {
        // Conditions where the battlecry won't work
        // Enemy Minions
        if (targetType == 1) {
            if (UtilityMethods.findEnemy(board, this).getPlayerSide().isEmpty()) {
                System.out.println("There are no valid targets.");
                return 10;
            }
        }
        // Friendly Minions
        else if (targetType == 2) {
            if (playerSide.isEmpty()) {
                System.out.println("There are no valid targets");
                return 10;
            }
        }
        // All Board
        else if (targetType == 3) {
            if (UtilityMethods.findEnemy(board, this).getPlayerSide().isEmpty() && playerSide.isEmpty()) {
                System.out.println("There are no valid targets");
                return 10;
            }
            promptTargetPlayer(board);
        }
        board.peekYourHand(this);
        board.peekBoard(this);
        System.out.println();
        System.out.println("What index would you like to target:");
        System.out.println("0 to target the hero, 1-7 left to target minions ");
        System.out.print("> ");
        int targetIndex = playerInput.nextInt() - 1;
        System.out.println();
        return targetIndex;
    }

    public void concede() {
        System.out.println("Well fought, I concede");
        System.out.println(name + " concedes!");
        int hpLeft = hero.getArmor() + hero.getHp();
        hero.addHp(this, -hpLeft);
    }

    /**
     * Casts heropower
     * @param player
     */
    public boolean heroPower(Player player, BoardState board) {
        return heroPower.Cast(player, board);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player) {
            Player ifSamePlayer = (Player) obj;
            return this.name.equals(ifSamePlayer.name);
        }
        return false;
    }

    public static void main(String[] args) {

        String decklist = UtilityMethods.fileParser("C:/Users/NSeffernick/Documents/TestFiles/Test1.txt");
        String decklist2 = UtilityMethods.fileParser("C:/Users/NSeffernick/Documents/TestFiles/Test1.txt");

        Player player1 = new Player(decklist, "Paladin", "CheechX2");
        Player player2 = new Player(decklist2, "Warlock", "CheechX3");

        BoardState theBoardState = new BoardState(player1, player2);
        theBoardState.startMulligan();
    }

    @Override
    public String toString() {
        return name + "\nMana: " + mana + "/" + manaCrystals + "\nHand size: " + hand.size()
                + "\nDeck size: " + deck.size();
    }
}