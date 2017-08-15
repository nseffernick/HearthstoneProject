package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class HasCharge extends Enchantments {

    public HasCharge(Minion link) {
        super(Keywords.CHARGE, "Charge", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}
