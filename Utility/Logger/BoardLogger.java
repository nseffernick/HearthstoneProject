package Utility.Logger;

import Game.BoardState;
import Game.Player.Player;

import java.io.File;

/*
 I don't know if I will end up using this class,
 I could see it as important later and it may take up more responsibility, but the
 problem I was having earlier was fixed so I'll just leave this here until I maybe want it.
 */
public class BoardLogger extends BoardState {

    //State
    private BoardState board;
    private File logFile;

    public BoardLogger(BoardState board) {
        super(board);
    }

    @Override
    public Player getP1() {
        return board.getP1();
    }

    @Override
    public Player getP2() {
        return board.getP2();
    }

    private void startTurn(Player player) {

    }
}
