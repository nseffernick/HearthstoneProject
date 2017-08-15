package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class AmaniEnrage extends Enchantments {

    public AmaniEnrage(Minion link) {
        super(Keywords.ENRAGE, "Amani Enrage", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        if (minion.isEnraged()) minion.addAtk(-3);
        else minion.addAtk(3);
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}
