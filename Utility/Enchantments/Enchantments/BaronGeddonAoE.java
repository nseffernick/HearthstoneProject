package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class BaronGeddonAoE extends Enchantments {

    public BaronGeddonAoE(Minion link) {
        super(Keywords.ENDOFYOURTURN, "Baron AoE", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        damageAllCharactersExceptThis(board, 2, minion);
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}
