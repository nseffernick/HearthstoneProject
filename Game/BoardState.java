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
            return p1;
        }
        else return p2;
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

        player.drawCard(this);
        if (!(player.getManaCyrstals() == 10)) {
            player.addManaCrystals(1);
        }
        if (!(player.getMana() == player.getManaCyrstals())) {
            int set = player.getManaCyrstals() - player.getMana();
            player.addMana(set);
        }
        player.checkBoardForDead();
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

    public void playerTurn(boolean canPlay, int turnNumber) {

        Player playerTurn = p2;
        if (canPlay) {
            playerTurn = p1;
        }

        startTurn(playerTurn);
        helpMessage();
        long startTime = System.nanoTime();
        long estimatedTime = System.nanoTime() - startTime;

        playerTurnLoop(playerTurn, canPlay, startTime, estimatedTime);
    }

    private void playerTurnLoop(Player player, boolean canPlay, long startTime, long estimatedTime) {

        while (1 == 1) {
            System.out.println("Time remaining: " + (1000 - estimatedTime) + " seconds remaining.");

            if (estimatedTime >= ROPE) {
                System.out.println("tsssss");
            }
            System.out.print("> ");
            String line = player.getPlayerInput().nextLine();
            String fields[] = line.split(" ");

            if (fields[0].equals(PASS)) {
                System.out.println(player.getName() + " ends their turn!");
                break;
            }
            commands(player, fields);

            estimatedTime = System.nanoTime() - startTime;
        }
        for (Minion minion: player.getPlayerSide()) {
            if (minion.getProperties().contains(Keywords.SUMMONSICKNESS)) {
                minion.getProperties().remove(Keywords.SUMMONSICKNESS);
            }
        }
    }

    private void commands(Player player, String[] fields) {
        switch (fields[0]) {
            case HELP:
                helpMessage();
                break;
            case QUIT:
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
                System.out.println("Unrecognized command " + fields[0]);
                break;
        }

    }

    private void playerCastsHeroPower(Player player) {
        System.out.println(player.getHeroPower());
        System.out.println();
        player.heroPower(player, this);
    }

    private void playerAttacks(Player player, String[] fields) {
        if (fields[1].equals("0")) {
            player.getHero().heroAttack(UtilityMethods.findEnemy(this, player), Integer.parseInt(fields[2]), this);
        }
        else {
            Minion minion = player.getPlayerSide().get(Integer.parseInt(fields[1]) - 1);
            MasterTargeter.Main(UtilityMethods.findEnemy(this, player), Integer.parseInt(fields[2]), 0, minion, false, this);
        }
    }

    private void playerPlaysACard(Player player, String[] fields) {
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
                    default:
                        System.out.println("Unrecognized command " + fields);
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
            default:
                System.out.println("Unrecognized command " + fields);
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
        System.out.println("Enemy Board:");
        System.out.println();
        System.out.println(UtilityMethods.findEnemy(this, player).getName());
        for (Card card : UtilityMethods.findEnemy(this, player).getPlayerSide()) {
            System.out.print(card);
        }
        System.out.println();
        System.out.println("Your Board:");
        System.out.println();
        System.out.println(player.getName());
        System.out.println();
        for (Card card : player.getPlayerSide()) {
            System.out.print(card);
        }
    }



    public static void main(String[] args) {

        String decklist = UtilityMethods.fileParser("C:/Users/NSeffernick/Documents/TestFiles/Test1.txt");
        String decklist2 = UtilityMethods.fileParser("C:/Users/NSeffernick/Documents/TestFiles/Test1.txt");

        Player player1 = new Player(decklist, "Paladin", "CheechX2");
        Player player2 = new Player(decklist2, "Mage", "CheechX3");

        BoardState theGame = new BoardState(player1, player2);

        boolean whoCanPlay = true;
        String p1Name = theGame.getP1().getName();
        String p2Name = theGame.getP2().getName();
        String p1Hero = theGame.getP1().getHero().getName();
        String p2Hero = theGame.getP2().getHero().getName();

        System.out.println("Hello " + p1Name + ", you are playing as " +  p1Hero + ",\nYour enemy " +
                p2Name + ", is playing as " + p2Hero + ".\n");
        int turnNumber = 0;

        while(!theGame.hasWon()) {
            turnNumber += 1;
            theGame.playerTurn(whoCanPlay, turnNumber);
            whoCanPlay = !whoCanPlay;
        }

        Player theyWon = theGame.whoWon();
        System.out.println(theyWon.getName() + " is victorious!");
        System.out.println("(fireworks explode... confetti litters the screen)");
    }

}