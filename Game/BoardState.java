package Game;

import Cards.Card;
import Cards.Minion;
import Game.Auras.Aura;
import Game.Player.*;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.Keywords.Keywords;

import java.util.LinkedList;
import java.util.Scanner;


/**
 * ME 3/19/17
 * Class that will run the game essentially
 * Takes care of time constraints, starts and ends turns, access to all
 * players, mulligan phase.
 */
public class BoardState {

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

    // State
    private Player p1;
    private Player p2;
    private LinkedList<Aura> auras;

    public BoardState(String deck1, String deck2, String hero1, String hero2, String name1, String name2) {

        this.auras = new LinkedList<Aura>();
        Player p1 = new Player(deck1, hero1, name1);
        Player p2 = new Player(deck2, hero2, name2);
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public LinkedList<Aura> getAuras() { return auras;};

    private boolean hasWon() {
        return p1.getHero().isDead() || p2.getHero().isDead();
    }

    private Player whoWon() {
        if (p1.getHero().isDead()) {
            return p1;
        }
        else return p2;
    }

    public Player findEnemy(Player player) {
        if (player.equals(p1)) {
            return p2;
        }
        else return p1;
    }

    private void applyAura(Aura aura) {

        LinkedList<Card> where = determineWhere(aura);
        String[] text = aura.getEffect().split(" ");
        int increment = getIncrement(text);
        modifyWhere(where, text, increment);
    }

    private LinkedList<Card> determineWhere(Aura aura) {

        String[] text = aura.getWhere().split(" ");

        Player player;
        if (text[0].equals("Friendly")) {
            player = p1;
        }
        else if (text[0].equals("Enemy")) {
            player = p2;
        }
        else player = null;

        return MasterTargeter.CustomTarget(player,text[1], aura.getTribe(),aura.getLink());
    }

    private void modifyWhere(LinkedList<Card> where, String[] text, int increment) {

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
                    minion.addHp(increment);
                }
            }
            else if(text[0].equals("Attack/Health")) {
                if (card instanceof Minion) {
                    Minion minion = (Minion) card;
                    minion.addMaxHP(increment);
                    minion.addHp(increment);
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

    public void removeAura(Aura aura) {

        if (checkAlive(aura));
        else {

            LinkedList<Card> where = determineWhere(aura);
            String[] text = aura.getEffect().split(" ");
            int increment = getIncrement(text);
            increment = increment - (2*increment);
            modifyWhere(where, text, increment);
        }
    }

    private boolean checkAlive(Aura aura) {

        return !aura.getLink().isDead() && aura.getLink().getProperties().contains(Keywords.AURA);
    }

    public void addAura(Aura aura) {

        auras.add(aura);
        applyAura(aura);
    }

    private void startMulligan() {

        p1.mulligan("first");
        p2.mulligan("second");
    }

    /**
     * Gain mana and draw a card
     * Probably will need to trigger start of turn effects as well
     * @param player
     */
    private void startTurn(Player player) {

        player.drawCard();
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

        System.out.println("command () {} {} (): <--- is a command " +
                "(optional command modifiers) {required command modifiers}");
        System.out.println();

        System.out.println("help: displays this message");

        System.out.println("peek (enemy) {hand, deck, board}: see details of your/enemy hand/deck/board");

        System.out.println("settings: display game settings (not implemented yet)");

        System.out.println("concede: give your opponent victory");

        System.out.println("quit: exits the program (may result, currently would, result in a loss");

        System.out.println("pass: pass your turn to the opponent");

        System.out.println("play {hand index, card name} (if a minion{'left', 'right', board index}):");
        System.out.println("Hand/board index goes left ---> right starting from 1," +
                " card name should be as displayed on the card");
        System.out.println("'left' and 'right' put minion at the edges");

        System.out.println("attack {board index, name} {board index, name}: " +
                "Choose a minion or hero to attack an enemy minion or hero");
        System.out.println("Index start at 0 as the hero, then left ---> right of the board starting at 1");
    }

    private void playerTurn(boolean canPlay) {

        Player playerTurn = p2;
        if (canPlay) {
            playerTurn = p1;
        }

        startTurn(playerTurn);
        helpMessage();
        long startTime = System.nanoTime();
        long estimatedTime = System.nanoTime() - startTime;
        System.out.print("> ");
        playerTurnLoop(playerTurn, canPlay, startTime, estimatedTime);
    }

    private void playerTurnLoop(Player player, boolean canPlay, long startTime, long estimatedTime) {

        while (player.getPlayerInput().hasNext() && estimatedTime <= TIME_LIMIT ) {

            if (estimatedTime == ROPE) {
                System.out.println("tsssss");
            }
            String line = player.getPlayerInput().nextLine();
            if (!canPlay) {
                System.out.println(line);
            }
            String fields[] = line.split("\\s+");

            if (fields[0].equals(PASS)) {
                System.out.println(player.getName() + " ends their turn!");
                break;
            }
            commands(player, fields);

            estimatedTime = System.nanoTime() - startTime;
        }
    }

    //Maybe TODO this entire thing but I'm prolly the only one that's going to use it so maybe it stays shitty
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
                switch (fields[1]) {
                    case "enemy":
                        switch (fields[2]) {
                            case "hand":
                                System.out.println("Your opponent has " + findEnemy(player).getHand().size() + " cards in their hand.");
                                break;
                            case "deck":
                                System.out.println("Your opponent has " + findEnemy(player).getDeck().size() + " cards in their deck.");
                                break;
                            case "board":
                                System.out.println("Enemy Board:");
                                for (Card card : findEnemy(player).getPlayerSide()) {
                                    System.out.print(card);
                                }
                                System.out.println();
                                System.out.println("Your Board:");
                                for (Card card : player.getPlayerSide()) {
                                    System.out.print(card);
                                }
                                break;
                            default:
                                System.out.println("Unrecognized command " + fields);
                                break;
                        }
                        break;
                    case "hand":
                        for (Card card : player.getHand()) {
                            System.out.println(card);
                        }
                        break;
                    case "deck":
                        System.out.println("You have has " + findEnemy(player).getDeck().size() + " cards in your deck.");
                        break;
                    case "board":
                        System.out.println("Enemy Board:");
                        for (Card card : findEnemy(player).getPlayerSide()) {
                            System.out.print(card);
                        }
                        System.out.println();
                        System.out.println("Your Board:");
                        for (Card card : player.getPlayerSide()) {
                            System.out.print(card);
                        }
                        break;
                    default:
                        System.out.println("Unrecognized command " + fields);
                        break;
                }
                break;
            case ATTACK:
                if (fields[1].equals("0")) {
                    player.getHero().heroAttack(findEnemy(player), Integer.parseInt(fields[2]));
                } else {
                    Minion minion = player.getPlayerSide().get(Integer.parseInt(fields[1]) - 1);
                    MasterTargeter.Main(findEnemy(player), Integer.parseInt(fields[2]), 0, minion, false);
                }
                //TODO Complete rework of playCard
                break;
            case PLAY:
                if (fields[1].matches("[0-9]")) {
                    Card card = player.getHand().get(Integer.parseInt(fields[1]) - 1);
                    player.playCard(card, Integer.parseInt(fields[2]), this);
                } else {
                    for (Card card : player.getHand()) {
                        if (fields[1].equals(card.getName())) {
                            player.playCard(card, Integer.parseInt(fields[2]), this);
                        }
                    }
                }
                break;
            default:
                System.out.println("Unrecognized command " + fields[0]);
                break;
        }

    }

    public void Main(String[] args) {

        BoardState theGame = new BoardState(args[0], args[1], args[2], args[3], args[4], args[5]);

        boolean whoCanPlay = true;
        String p1Name = theGame.p1.getName();
        String p2Name = theGame.p2.getName();
        String p1Hero = theGame.p1.getHero().getName();
        String p2Hero = theGame.p2.getHero().getName();


        System.out.println("Hello " + p1Name + ", you are playing as " +  p1Hero + ",\n Your enemy " +
                p2Name + ", is playing as " + p2Hero);
        theGame.startMulligan();

        while(!hasWon()) {

            playerTurn(whoCanPlay);
            whoCanPlay = !whoCanPlay;
        }

        Player theyWon = whoWon();
        System.out.println(theyWon.getName() + " is victorious!");
        System.out.println("(fireworks explode... confetti litters the screen)");
    }

}