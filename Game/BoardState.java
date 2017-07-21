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
    private final int TIME_LIMIT = 91;
    private final int ROPE = 75;
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

    // State
    private Player p1;
    private Player p2;
    private LinkedList<Aura> auras;
    private int turn;

    public BoardState(String deck1, String deck2, String hero1, String hero2, String name1, String name2) {

        this.turn = STARTING_TURN;
        this.auras = new LinkedList<Aura>();
        Player p1 = new Player(deck1, hero1, name1, 1, this);
        Player p2 = new Player(deck2, hero2, name2,2, this);
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
    public void startTurn(Player player) {

        player.drawCard();
        if (!(player.getMana() == 10)) {
            player.addMana(1);
        }

    }

    public void endTurn() {


    }

    public Player findEnemy(Player player) {
        if (player.equals(p1)) {
            return p2;
        }
        else {
            return p1;
        }
    }

    private void helpMessage() {
        System.out.println("course {id}: list a course");
        System.out.println("courses: list all courses (by course id)");
        System.out.println("enroll {username} {id}: enroll a student in a course");
        System.out.println("help: this message");
        System.out.println("professor {username}: list courses taught by professor (by course level then by course name)");
        System.out.println("student {username}: list courses taken by student (by course name)");
        System.out.println("enroll {username} {id}: unenroll a student from a course");
        System.out.println("users: list all users (alphabetically by username) ");
        System.out.println("quit: quit HearthstoneProject");
    }

    public void playerTurn(Scanner playerInput, boolean canPlay) {
        if (canPlay) {
            System.out.println("Type 'help' for the list of commands.");
        }
        System.out.print("> ");
        // continue looping until there is no more input
        while (playerInput.hasNext()) {

            String line = playerInput.nextLine();

            if (!canPlay) {
                System.out.println(line);
            }
            String fields[] = line.split("\\s+");

            if (fields[0].equals(HELP)) {
                helpMessage();
            } else if (fields[0].equals(QUIT)) {
                break;
            } else if (fields[0].equals(CONCEDE)) {

            } else if (fields[0].equals(SETTINGS)) {

            } else if (fields[0].equals(PEEK)) {
                int id = Integer.parseInt(fields[2]);

            } else if (fields[0].equals(ATTACK)) {

            } else if (fields[0].equals(PLAY)) {

            } else {
                System.out.println("Unrecognized command " + fields[0]);
            }
        }
    }

    public void turnTime() {

        long startTime = System.nanoTime();
        long estimatedTime = System.nanoTime() - startTime;
        while (estimatedTime <= TIME_LIMIT) {
            if (estimatedTime == ROPE) {
                System.out.println("tsssss");
            }
            // player does things
            // unless player wins or ends turn by himself

        }
        endTurn();
    }

    public void hasWon() {

    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public LinkedList<Aura> getAuras() { return auras;};

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
        else {
            player = null;
        }

        return MasterTargeter.CustomTarget(player,text[1],
                aura.getTribe(),aura.getLink());
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

        if (aura.getLink().isDead() || !aura.getLink().getProperties().contains(Keywords.AURA)) {
            return false;
        }
        return true;
    }

    public void addAura(Aura aura) {

        auras.add(aura);
        applyAura(aura);
    }

    public static void Main(String[] args) {

        BoardState theGame = new BoardState(args[0], args[1], args[2], args[3], args[4], args[5]);

        Scanner p1Input = new Scanner(System.in);
        Scanner p2Input = new Scanner(System.in);
        boolean p1CanPlay;
        boolean p2CanPlay;
        // Scanner limitedcommandsp1;
        // Scanner limitedcommandsp2;
        // boolean p1CanLimited;
        // boolean p2CanLimited;
        String p1Name = theGame.p1.getName();
        String p2Name = theGame.p2.getName();
        String p1Hero = theGame.p1.getHero().getName();
        String p2Hero = theGame.p2.getHero().getName();


        System.out.println("Hello " + p1Name + ", you are playing as " +  p1Hero + ",\n Your enemy " +
                p2Name + ", is playing as " + p2Hero);
        theGame.startMulligan();
    }

}