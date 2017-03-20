import deque;
import random;


/**
 * ME 3/19/17
 */
public class BoardState {

    // Constants
    private final int TIME_LIMIT = 90;
    private final int ROPE = 15;
    private final int STARTING_TURN = 0;

    // State
    private Player p1;
    private Player p2;
    private int turn;

    public BoardState(Player p1, Player p2) {
        this.turn = STARTING_TURN;
        Player p1 = new Player(deck1);
        Player p2 = new Player(deck2);

        startMulligan(p1, p2);
    }

    private void startMulligan(Player p1, Player p2) {

        p1.mulligan("first");
        p2.mulligan("second");
    }

    public void startTurn(Player player) {

    }

    public void hasWon(Player player) {

    }



}