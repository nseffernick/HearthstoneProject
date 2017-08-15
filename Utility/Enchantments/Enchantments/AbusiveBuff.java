package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class AbusiveBuff extends Enchantments {

    public AbusiveBuff(Minion link) {
        super(Keywords.ENDOFYOURTURN, "+2 Temporary Attack", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        minion.addAtk(2);
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
        minion.addAtk(-2);
    }
}
