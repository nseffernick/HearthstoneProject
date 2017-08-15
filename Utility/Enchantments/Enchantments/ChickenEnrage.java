package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class ChickenEnrage extends Enchantments {

    public ChickenEnrage(Minion link) {
        super(Keywords.ENRAGE, "Amani Enrage", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        if (minion.isEnraged()) minion.addAtk(-5);
        else minion.addAtk(5);
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}
