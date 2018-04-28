package Game.Player;

import Cards.Structure.Card;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Cards.Structure.Weapon;
import Game.Auras.Aura;
import Game.BoardState;
import Game.Player.HeroPowers.HeroPower;
import Game.Targetable;
import Utility.Enchantments.Enchantments.Keywords.HasSummonSickness;
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
    private final int MAX_MANA_POOL = 10;
    private final int INVALID_INDEX = 10;
    //private final int ANY_TARGET = 0;
    private final int FRIENDLY_TARGET = 1;
    private final int ENEMY_TARGET = 2;
    private final int HERO_TARGET = -1;

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

    //TODO idea add system that notifies minions/heros in order when something happens

    /**
     * Initializes deck
     * @param decklist
     * @return
     */
    private LinkedList<Card> initializeDeck(String decklist) {
        LinkedList<Card> deck = new LinkedList<>();
        String[] decklistArr = decklist.split(" ");
        for (String card : decklistArr) {
            makeCardFromClass(deck, card);
        }
        return deck;
    }

    /**
     * Creates a card addes to deck
     * @param deck
     * @param card
     */
    private void makeCardFromClass(LinkedList<Card> deck, String card) {
        try {
            Class newCard = Class.forName(card);
            Constructor<Player> constructor = newCard.getConstructor(Player.class);
            Object card1 = constructor.newInstance(this);
            if (card1 instanceof Card) {
                Card card2 = (Card) (card1);
                deck.add(card2);
            }
        }
        catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException
                | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /*
    Various getters and setters
    Prolly should get rid of these at some point
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

    public void addManaCrystals(int set) {
        if (manaCrystals < MAX_MANA_POOL) { //must be less than 10
            int totalMana = manaCrystals + set;
            if (totalMana > MAX_MANA_POOL ) {
                set = totalMana - MAX_MANA_POOL;
            }
            manaCrystals += set;
        }
    }

    /**
     * Draws card from deck
     * Accounts for max hand size of 10
     * @param board
     */
    public void drawCard(BoardState board) {
        if (!deck.isEmpty()) {
            Card card = deck.remove();
            addToHand(card);
        }
        else {
            fatigue += 1;
            hero.addHp(-fatigue);
        }
    }

    /**
     * Card is put into hand
     * @param card
     */
    private void addToHand(Card card) {
        if (hand.size() < MAX_HAND_SIZE) {
            hand.add(card);
            updateCardCostFromHand();
        }
        else System.out.println(card + " was burned!");
    }

    /**
     * Runs the mulligan phase
     */
    public void mulligan(Player player, BoardState board) {

        Scanner chooseCard = playerInput;

        int i = 0;
        int pos = 0;
        int mullCount = 0;

        if (player == board.getP1()) {
            firstPlayerMulligan(chooseCard, i, pos, mullCount, board);
        }

        else {
            secondPlayerMulligan(chooseCard, i, pos, mullCount, board);
        }
    }

    private void secondPlayerMulligan(Scanner chooseCard, int i, int pos, int mullCount, BoardState board) {
        int[] intArr = {12, 21, 23, 232};
        System.out.println("You are going second.");
        drawCard(board);
        drawCard(board);
        drawCard(board);
        drawCard(board);
        mullCount = getMullCount(chooseCard, i, pos, mullCount, intArr);
        drawAndMullBackCards(mullCount, intArr, board);
        rng.shuffle(this.deck);
        System.out.println(hand);
    }


    private void drawAndMullBackCards(int mullCount, int[] intArr, BoardState board) {
        int pos;
        while (mullCount > 0){
            drawCard(board);
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
    }

    private int getMullCount(Scanner chooseCard, int i, int pos, int mullCount, int[] intArr) {
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
        return mullCount;
    }

    private void firstPlayerMulligan(Scanner chooseCard, int i, int pos, int mullCount, BoardState board) {
        int[] intArr = {12, 21, 23};
        System.out.println("You are going first.");
        drawCard(board);
        drawCard(board);
        drawCard(board);
        mullCount = getMullCount(chooseCard, i, pos, mullCount, intArr);
        drawAndMullBackCards(mullCount, intArr, board);
        rng.shuffle(this.deck);
        System.out.println(hand);
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

    /* Prolly getting rid of the idea of auras just kind of dumb
    private void applyAura(Aura aura, BoardState board) {

        LinkedList<Card> where = determineAffectedCards(aura, board);
        String[] text = aura.getEffect().split(" ");
        int increment = getIncrement(text);
        modifyAffectedCards(where, text, increment, board);
    }

    private LinkedList<Card> determineAffectedCards(Aura aura, BoardState board) {

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

    private void modifyAffectedCards(LinkedList<Card> where, String[] text, int increment, BoardState board) {

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
                }
            }
            else if(text[0].equals("Attack/Health")) {
                if (card instanceof Minion) {
                    Minion minion = (Minion) card;
                    minion.addMaxHP(increment);
                    minion.addAtk(increment);
                }
            }
            else if(text[0].equals("Cost")) {
                card.addCost(increment);
            }
        }

    }

    public void removeAura(Aura aura, BoardState board) {
        if (checkForAura(aura));
        else {
            LinkedList<Card> where = determineAffectedCards(aura, board);
            String[] text = aura.getEffect().split(" ");
            int increment = getIncrement(text);
            increment = -increment;
            modifyAffectedCards(where, text, increment, board);
        }
    }

    private boolean checkForAura(Aura aura) {
        return !aura.getLink().isDead() && aura.getLink().getEnchantments().contains(Keywords.AURA);
    }

    public void addAura(Aura aura, BoardState board) {
        auras.add(aura);
        applyAura(aura, board);
    }
    */

    /*                                           What is this for
    private int getIncrement(String[] text) {
        int increment = Integer.parseInt(text[2]);
        if(text[1].charAt(0) ==  '-') {
            increment = increment - (2*increment);
        }
        return increment;
    }
    */

    /**
     * Pre-Condition gives a correct index
     * Very rough, will definitely need to update
     *
     * A player cannot play a minion if the board space will be full when summoned
     * @param card - card player is playing from hand
     */
    public void playCard(Card card, int index, BoardState board) {
        if (!(card.getCost() > mana)) {
            // If card is a minion
            if (card instanceof Minion) {
                if (playerSide.size() < BOARD_SLOTS) {
                    hand.remove(card);
                    playMinion(card, index, board);
                }
                System.out.println("The board is full");
            }
            // If card is a spell
            else if (card instanceof Spell) {
                hand.remove(card);
                Spell spell = (Spell) (card);
            }
            // If card is a weapon
            else if (card instanceof Weapon) {
                hand.remove(card);
                Weapon weapon = (Weapon) (card);
            }
        }
        else {
            System.out.println("You do not have enough mana to cast: " + card.getName());
        }
    }

    private void playMinion(Card card, int index, BoardState board) {
        Minion minion = (Minion) (card);
        minion.getEnchantments().add(new HasSummonSickness(minion));
        minion.battlecry(board, this, index);
        if (playerSide.isEmpty()) {
            playerSide.add(minion);
        }
        else playerSide.add(index, minion);
        if (card.getCost() <= 0);
        else addMana(-card.getCost());
        minion.createAura(board);
        updateCardCostFromBoard(board);
        procFromCardPlayed(minion, board);
        procFromMinionSummoned(minion, board);
        checkBoardForDead();
    }

    /**
     * Many things in the game summon minions, playing cards, on board
     * effects, spells.
     * Needs to account for board space even when not playing a card
     * @param minion
     * @param board
     */
    public void summonMinion(Minion minion, BoardState board) {
        if (playerSide.size() < BOARD_SLOTS) {
            minion.getEnchantments().add(new HasSummonSickness(minion));
            minion.createAura(board);
            playerSide.add(minion);
            updateCardCostFromBoard(board);
            procFromMinionSummoned(minion, board);
        }
    }

    public void checkBoardForDead() {
        for (Minion minion : playerSide) {
            if (minion.isDead()) {
                placeCardInGraveyard(minion);
            }
        }
    }

    public void placeCardInGraveyard(Card card) {
        if (card instanceof Minion) {
            placeMinionInGraveyard((Minion) card);
        }
    }

    private void placeMinionInGraveyard(Minion card) {
        playerSide.remove(card);
        Object card1 = constructDefaultCard(card);
        if (card1 instanceof Card) {
            Card card2 = (Card) (card1);
            graveyard.add(card2);
        }
    }

    private Object constructDefaultCard(Minion card) {
        Class newCard = card.getClass();
        Object card1 = null;
        try {
            Constructor constructor = newCard.getConstructor(Player.class);
            card1 = constructor.newInstance(this);
        }
        catch (InstantiationException | InvocationTargetException | IllegalAccessException |  NoSuchMethodException e) {
            e.printStackTrace();
        }
        return card1;
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

    /**
     * Transforming a minion, important to know that it doesn't get put into graveyard
     * @param originalMinion
     * @param newMinion
     */
    public void transform(Minion originalMinion, Minion newMinion) {
        int index = playerSide.indexOf(originalMinion);
        playerSide.set(index, newMinion);
    }

    /*  LIKE I DONT KNOW WHY I NEED ALL OF THIS SEEMS LIKE IT COULD BE MORE GENERAL */
    /**
     * Ask for a player, reason we need targetType, and that this method is private
     * is that different spells/targetable actions can only affect the enemy/friendlies
     * @param board
     * @param targetType
     * @return
     */
    public Player promptTargetPlayer(BoardState board, int targetType) {
        Player player;
        if (targetType == FRIENDLY_TARGET) {
            player = this;
        }
        else if (targetType == ENEMY_TARGET) {
            player = UtilityMethods.findEnemy(board, this);
        }
        else {
            System.out.println("Will your target be the enemy, " + UtilityMethods.findEnemy(board, this).name +
                    ", or yourself");
            System.out.println("Valid Responses are 'me' and 'enemy'");
            System.out.print(">");
            String aString = playerInput.next("(me)|(enemy)");
            System.out.println();
            if (aString.equals("me")) {
                player = this;
            }
            else {
                player = UtilityMethods.findEnemy(board, this);
            }
        }
        return player;
    }

    /**
     * Where a player asks for a target, whether it be for a battlecry/spell
     * @param board
     * @param player
     * @return
     */
    public int promptTargetIndex(BoardState board, Player player) {
        // Conditions where the battlecry won't work
        board.peekYourHand(this);
        board.peekBoard(this);
        System.out.println();
        System.out.println("What index would you like to target:");
        System.out.println("0 to target the hero, 1-7 left to target minions ");
        System.out.print("> ");
        int targetIndex = playerInput.nextInt() - 1;
        if (targetIndex < -1 || targetIndex > player.getPlayerSide().size() - 1) {
            return INVALID_INDEX;
        }
        System.out.println();
        return targetIndex;
    }

    /**
     * Checks if there a minions on the board
     * @param board
     * @param targetType
     * @return
     */
    private boolean canTargetMinion(BoardState board, int targetType) {
        if (board.isBoardEmpty()) {
            System.out.println("There are minions to target.");
            return false;
        }
        else if (targetType == FRIENDLY_TARGET) {
            if (playerSide.isEmpty()) {
                System.out.println("There are no minions to target.");
                return false;
            }
        }
        else if (targetType == ENEMY_TARGET) {
            if (UtilityMethods.findEnemy(board, this).getPlayerSide().isEmpty()) {
                System.out.println("There are no minions to target.");
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the minion at a certain index from a certain player
     * @param board
     * @param targetType
     * @return a mionion
     */
    private Minion targetAMinion(BoardState board, int targetType) {
        Player player = promptTargetPlayer(board, targetType);
        int index = targetMinionIndex(board, player);
        if (index == INVALID_INDEX) {//what do case
            return null;
        }
        return player.getPlayerSide().get(index);
    }

    /**
     * Allows player to pick index of minion
     * @param board
     * @param player
     * @return
     */
    private int targetMinionIndex(BoardState board, Player player) {
        board.peekYourHand(this);
        board.peekBoard(this);
        System.out.println();
        System.out.println("What index would you like to target:");
        System.out.println("1-7 left to right to target minions. (Invalid index will cancel cast/battlecry)");
        System.out.print("> ");
        int targetIndex = playerInput.nextInt() - 1;
        if (targetIndex < 0 || targetIndex > player.getPlayerSide().size() - 1) {
            return INVALID_INDEX;
        }
        System.out.println();
        return targetIndex;
    }

    /**
     * Returns a minion that is targeted
     * @param board
     * @param targetType
     * @return
     */
    public Minion promptAMinion(BoardState board, int targetType) {
        if (canTargetMinion(board, targetType)) {
            return targetAMinion(board, targetType);
        }
        return null;
    }

    /**
     * Prompts for any target
     * @param board
     * @param targetType
     * @return
     */
    public Targetable promptATarget(BoardState board, int targetType) {
        if (targetType == FRIENDLY_TARGET) {
            int index = promptTargetIndex(board, this);
            if (index == INVALID_INDEX) { // What do we do when invalid
                return null;
            }
            else if (index == HERO_TARGET) {
                return hero;
            }
            else {
                return playerSide.get(index);
            }
        }
        else if (targetType == ENEMY_TARGET) {
            int index = promptTargetIndex(board, UtilityMethods.findEnemy(board, this));
            if (index == INVALID_INDEX) {
                return null;
            }
            else if (index == HERO_TARGET) {
                return UtilityMethods.findEnemy(board, this).getHero();
            }
            else {
                return UtilityMethods.findEnemy(board, this).getPlayerSide().get(index);
            }
        }
        else {
            Player player = promptTargetPlayer(board, targetType);
            int index = promptTargetIndex(board, player);
            if (index == INVALID_INDEX) {
                return null;
            }
            else if (index == HERO_TARGET) {
                return player.getHero();
            }
            else {
                return player.playerSide.get(index);
            }
        }
    }
    //end game
    public void concede() {
        System.out.println("Well fought, I concede");
        System.out.println(name + " concedes!");
        //TODO end game
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