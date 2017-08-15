package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class AcolyteText extends Enchantments {

    public AcolyteText(Minion link) {
        super(Keywords.ONHIT, "Acolyte Draw", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        minion.getOwner().drawCard();
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {

    }
}
