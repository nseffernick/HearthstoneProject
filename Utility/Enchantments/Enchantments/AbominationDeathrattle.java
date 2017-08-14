package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class AbominationDeathrattle extends Enchantments {

    public AbominationDeathrattle(Keywords keyword, String name) {
        super(Keywords.DEATHRATTLE, "Abomination Deathrattle");
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        damageAllCharacters(board, 2);
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {

    }
}
