package Utility.TempBuffs;

import Cards.Structure.Minion;
import Game.BoardState;

public interface TempBuff {

    void tempBuff(BoardState board);

    void removeBuff();
}
