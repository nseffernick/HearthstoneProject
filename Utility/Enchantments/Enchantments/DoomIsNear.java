package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;
import Utility.UtilityMethods.UtilityMethods;

public class DoomIsNear extends Enchantments {

    public DoomIsNear(Minion link) {
        super(Keywords.STARTOFYOURTURN, "Kill all minions", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        for (Minion minion1: link.getOwner().getPlayerSide()) {
            minion1.destroy(board);
        }
        for (Minion minion1: UtilityMethods.findEnemy(board, link.getOwner()).getPlayerSide()) {
            minion1.destroy(board);
        }
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}