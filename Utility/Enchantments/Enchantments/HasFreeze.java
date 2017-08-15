package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class HasFreeze extends Enchantments {

    public HasFreeze(Minion link) {
        super(Keywords.FREEZE, "Frozen", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}
