package Player;

import java.util.Queue;
import java.util.LinkedList;

/**
 *
 */
public class Player {

    // CONSTANTS
    private final int STARTING_MANA = 0;
    private final int BOARD_SLOTS = 7;

    // State
    private int mana;
    private Queue playerSide;
    private Queue deck;
    private Queue hand;
    private Hero hero;
    // private AI type;

    public Player(Queue deck) {
        this.mana = STARTING_MANA;
        this.hero = hero;
        playerSide = new LinkedList<>();
    }

    public Queue getDeck() {
        return deck;
    }

    public Queue getHand() {
        return hand;
    }

    public void endTurn() {

    }

    public void playCard(Queue hand) {

    }

    public void drawCard() {

    }

    public void heroPower(Hero hero) {

    }

}