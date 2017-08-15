package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class DeathrattleDraw extends Enchantments {

    public DeathrattleDraw(Minion link) {
        super(Keywords.DEATHRATTLE, "Deathrattle: Draw a Card", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        minion.getOwner().drawCard();
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}