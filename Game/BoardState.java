package Game;

import Player.*;
import


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

    public BoardState(String deck1, String deck2, String hero1, String hero2) {
        this.turn = STARTING_TURN;
        Player p1 = new Player(deck1, hero1);
        Player p2 = new Player(deck2, hero2);

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