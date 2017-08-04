package Utility.TempBuffs;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Keywords.Keywords;

public final class TwoAttackBuff implements TempBuff {

    // State
    private Minion link;

    public TwoAttackBuff(Minion link) {
        this.link = link;
    };

    @Override
    public final void tempBuff(BoardState board) {
        board.getTempBuffs().add(this);
        link.getProperties().add(Keywords.TEMPBUFF);
        link.addAtk(2);
    }

    @Override
    public final void removeBuff() {
        if (link.getProperties().contains(Keywords.TEMPBUFF)) {
            link.addAtk(-2);
            link.getProperties().remove(Keywords.TEMPBUFF);
        }
    }
}
