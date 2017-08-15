package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class DrawOnMinionDeath extends Enchantments {

    public DrawOnMinionDeath(Minion link) {
        super(Keywords.MINIONDEATH, "Draw on Minion Death", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        if (minion.getOwner() == link.getOwner()) {
            link.getOwner().drawCard();
        }
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}