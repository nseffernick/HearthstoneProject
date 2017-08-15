package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class HasDivineShield extends Enchantments {

    public HasDivineShield(Minion link) {
        super(Keywords.DIVINESHIELD, "Divine Shield", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}
