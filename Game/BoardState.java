package Game;

import Cards.Structure.Card;
import Cards.Structure.Minion;
import Game.Player.*;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.Keywords.Keywords;
import Utility.UtilityMethods.UtilityMethods;

import java.util.Observable;

/**
 * ME 3/19/17
 * Class that will run the game essentially
 * Takes care of time constraints, starts and ends turns, access to all
 * players, mulligan phase.
 */
public class BoardState extends Observable {

    // Constants
    private final int TIME_LIMIT = 1001;
    private final int ROPE = 976;
    private final int STARTING_TURN = 0;

    // Commands
    /** the peek command */
    public final static String PEEK = "peek";
    /** the settings command */
    public final static String SETTINGS = "settings";
    /** the concede command */
    public final static String CONCEDE = "concede";
    /** the help command */
    public final static String HELP = "help";
    /** the play command */
    public final static String PLAY = "play";
    /** the attack command */
    public final static String ATTACK = "attack";
    /** the quit command */
    public final static String QUIT = "quit";
    /** the pass command */
    public final static String PASS = "pass";
    /** the heropower command */
    public final static String HEROPOWER = "heropower";

    // State
    private Player p1;
    private Player p2;

    public BoardState(String deck1, String deck2, String hero1, String hero2, String name1, String name2) {
        Player p1 = new Player(deck1, hero1, name1);
        Player p2 = new Player(deck2, hero2, name2);
    }

    public BoardState(BoardState board) {
        Player p1 = board.getP1();
        Player p2 = board.getP2();
    }

    public BoardState(String params) {
        String[] p = params.split(" ");
        Player p1 = new Player(p[0], p[1], p[2]);
        Player p2 = new Player(p[3], p[4], p[5]);
    }

    public BoardState(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    private boolean hasWon() {
        return p1.getHero().isDead() || p2.getHero().isDead();
    }

    private Player whoWon() {
        if (p1.getHero().isDead()) {
            return p2;
        }
        else return p1;
    }

    public void startMulligan() {
        p1.mulligan(p1, this);
        p2.mulligan(p2, this);
    }

    /**
     * Gain mana and draw a card
     * Probably will need to trigger start of turn effects as well
     * @param player
     */
    private void startTurn(Player player) {

        player.drawCard();
        if (!(player.getManaCrystals() == 10)) {
            player.addManaCrystals(1);
        }
        if (!(player.getMana() == player.getManaCrystals())) {
            int set = player.getManaCrystals() - player.getMana();
            player.addMana(set);
        }
        player.checkBoardForDead(this);
    }

    private void helpMessage() {
        System.out.println();
        System.out.println("command () {} {} (): <--- is a command " +
                "(optional command modifiers) {required command modifiers}");
        System.out.println();

        System.out.println("help: displays this message \n");

        System.out.println("peek (enemy) {hand, deck, board, hero, heropower}: " +
                "see details of your/enemy hand/deck/board... \n");

        System.out.println("settings: display game settings (not implemented yet) \n");

        System.out.println("concede: give your opponent victory \n");

        System.out.println("quit: exits the program (may result, currently would, result in a loss \n");

        System.out.println("pass: pass your turn to the opponent \n");

        System.out.println("play {hand index, card name} (if a minion{'left', 'right', board index}):");
        System.out.println("Hand/board index goes left ---> right starting from 1," +
                " card name should be as displayed on the card");
        System.out.println("'left' and 'right' put minion at the edges \n");

        System.out.println("attack {board index, name} {board index, name}: " +
                "Choose a minion or hero to attack an enemy minion or hero");
        System.out.println("Index start at 0 as the hero, then left ---> right of the board starting at 1 \n");

        System.out.println("heropower: Cast your Hero Power \n");
    }

    private void playerTurn(boolean canPlay) {

        Player currPlayer = p2;
        if (canPlay) {
            currPlayer = p1;
        }

        startTurn(currPlayer);
        helpMessage();
        long startTime = System.nanoTime();
        long estimatedTime = System.nanoTime() - startTime;

        playerTurnLoop(currPlayer, startTime, estimatedTime);
        removeAttackLimits(currPlayer);
        doEndOfTurnEffects(currPlayer);
    }

    private void playerTurnLoop(Player player, long startTime, long estimatedTime) {

        while (!this.hasWon()) {
            //System.out.println("Time remaining: " + (1000 - estimatedTime) + " seconds remaining.");
            //if (estimatedTime >= ROPE) { System.out.println("tsssss"); }

            System.out.print("> ");
            String line = player.getPlayerInput().nextLine();
            System.out.println();
            String fields[] = line.split(" ");

            if (fields[0].equals(PASS)) {
                System.out.println(player.getName() + " ends their turn!");
                break;
            }
            commands(player, fields);

            //estimatedTime = System.nanoTime() - startTime;
        }
    }

    private void GameLoop(BoardState theGame, boolean whoCanPlay, int turnNumber) {
        while(!theGame.hasWon()) {
            turnNumber += 1;
            theGame.playerTurn(whoCanPlay);
            whoCanPlay = !whoCanPlay;
        }
    }

    private void removeAttackLimits(Player player) {
        for (Minion minion : player.getPlayerSide()) {
            minion.getProperties().removeIf(keyword -> keyword == Keywords.HASATTACKED || keyword == Keywords.SUMMONSICKNESS);
        }
        player.getHeroPower().refreshHeroPower();
    }

    private void doEndOfTurnEffects(Player player) {
        for (Minion minion: player.getPlayerSide()) {
            minion.endOfYourTurn(this);
        }
        for (Minion minion: this.getP1().getPlayerSide()) {
            minion.endOfTurn(this);
        }
        for (Minion minion: this.getP2().getPlayerSide()) {
            minion.endOfTurn(this);
        }
    }

    private void commands(Player player, String[] fields) {
        switch (fields[0]) {
            case HELP:
                helpMessage();
                break;
            case QUIT:
                System.out.println(player.getName() + " quitting...");
                System.exit(0);
            case CONCEDE:
                player.concede();
                break;
            case SETTINGS:
                System.out.println("Sorry there are no settings yet :(");
                break;
            case PEEK:
                playerPeek(player, fields);
                break;
            case ATTACK:
                playerAttacks(player, fields);
                break;
            case PLAY:
                playerPlaysACard(player, fields);
                break;
            case HEROPOWER:
                playerCastsHeroPower(player);
                break;
            default:
                System.out.println("Unrecognized command \"" + fields[0] + "\"");
                break;
        }
    }

    private void playerCastsHeroPower(Player player) {
        System.out.println(player.getHeroPower());
        System.out.println();
        if (!(player.getHeroPower().getCost() > player.getMana())) {
            if (!player.getHeroPower().getWasCast()) {
                if (player.heroPower(player, this)) {
                    player.addMana(-player.getHeroPower().getCost());
                }
                else System.out.println("Hero power canceled...");
            }
            else System.out.println("Hero power was already cast.");
        }
        else System.out.println("You do not have enough mana to cast your hero power.");
    }

    private void playerAttacks(Player player, String[] fields) {
        if (fields[1].equals("0")) {
            player.getHero().heroAttack(UtilityMethods.findEnemy(this, player), Integer.parseInt(fields[2]), this);
        }
        else {
            Minion minion;
            try {
                minion = player.getPlayerSide().get(Integer.parseInt(fields[1]) - 1);
                MasterTargeter.Main(UtilityMethods.findEnemy(this, player), Integer.parseInt(fields[2]) - 1, 0, minion, false, this);
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid Index, Most likely issue: Size needs to be greater than index.");
                System.out.println(e.getMessage());
            }
        }
    }

    private void playerPlaysACard(Player player, String[] fields) {
        try {
            if (fields[1].matches("[0-9]")) {
                Card card = player.getHand().get(Integer.parseInt(fields[1]) - 1);
                player.playCard(card, Integer.parseInt(fields[2]), this);
            }
            else {
                for (Card card : player.getHand()) {
                    if (fields[1].equals(card.getName())) {
                        player.playCard(card, Integer.parseInt(fields[2]), this);
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid Index, Most likely issue: Size needs to be greater than index.");
            System.out.println(e.getMessage());
        }
    }

    public void playerPeek(Player player, String[] fields) {
        switch (fields[1]) {
            case "enemy":
                switch (fields[2]) {
                    case "hand":
                        System.out.println("Your opponent has " + UtilityMethods.findEnemy(this, player).getHand().size() + " cards in their hand.");
                        break;
                    case "deck":
                        System.out.println("Your opponent has " + UtilityMethods.findEnemy(this, player).getDeck().size() + " cards in their deck.");
                        break;
                    case "board":
                        peekBoard(player);
                        break;
                    case "hero":
                        System.out.println(UtilityMethods.findEnemy(this, player).getHero());
                        break;
                    case "heropower":
                        System.out.println(UtilityMethods.findEnemy(this, player).getHeroPower());
                        break;
                    case "info":
                        System.out.println(UtilityMethods.findEnemy(this, player));
                        break;
                    default:
                        System.out.println("Unrecognized command \"" + fields + "\"");
                        break;
                }
                break;
            case "hand":
                peekYourHand(player);
                break;
            case "deck":
                System.out.println("You have has " + UtilityMethods.findEnemy(this, player).getDeck().size() + " cards in your deck.");
                break;
            case "board":
                peekBoard(player);
                break;
            case "hero":
                System.out.println(player.getHero());
                break;
            case "heropower":
                System.out.println(player.getHeroPower());
                break;
            case "info":
                System.out.println(player);
                break;
            default:
                System.out.println("Unrecognized command \"" + fields + "\"");
                break;
        }
    }

    public void peekYourHand(Player player) {
        System.out.println("Your Hand:");
        for (Card card : player.getHand()) {
            System.out.println(card);
        }
    }

    public void peekBoard(Player player) {
        System.out.print(UtilityMethods.findEnemy(this, player).getName());
        System.out.println("  Enemy Board:");
        for (Card card : UtilityMethods.findEnemy(this, player).getPlayerSide()) {
            System.out.print(card);
        }
        System.out.println();
        System.out.print(player.getName());
        System.out.println("  Your Board:");
        for (Card card : player.getPlayerSide()) {
            System.out.print(card);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        String decklist = UtilityMethods.fileParser("C:/Users/NSeffernick/Documents/TestFiles/Test1.txt");
        String decklist2 = UtilityMethods.fileParser("C:/Users/NSeffernick/Documents/TestFiles/Test1.txt");

        Player player1 = new Player(decklist, "Paladin", "CheechX2");
        Player player2 = new Player(decklist2, "Mage", "CheechX3");

        BoardState theGame = new BoardState(player1, player2);
        player1.addManaCrystals(8);
        player2.addManaCrystals(8);

        boolean whoCanPlay = true;
        String p1Name = theGame.getP1().getName();
        String p2Name = theGame.getP2().getName();
        String p1Hero = theGame.getP1().getHero().getName();
        String p2Hero = theGame.getP2().getHero().getName();

        System.out.println("Hello " + p1Name + ", you are playing as " +  p1Hero + ",\nYour enemy " +
                p2Name + ", is playing as " + p2Hero + ".\n");
        int turnNumber = 0;

        theGame.GameLoop(theGame, whoCanPlay, turnNumber);

        Player theyWon = theGame.whoWon();
        System.out.println(theyWon.getName() + " is victorious!");
        System.out.println("(fireworks explode... confetti litters the screen)");
    }

}