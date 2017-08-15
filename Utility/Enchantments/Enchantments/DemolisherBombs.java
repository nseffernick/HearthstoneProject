package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;
import Utility.UtilityMethods.UtilityMethods;

public class DemolisherBombs extends Enchantments {

    public DemolisherBombs(Minion link) {
        super(Keywords.STARTOFYOURTURN, "Hurls 2 damage bombs", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        int index = link.getOwner().getRng().randomNum(UtilityMethods.findEnemy(board, link.getOwner()).getPlayerSide().size()) - 1;
        Damaging.damageCharacter(UtilityMethods.findEnemy(board, link.getOwner()), index, 2, board);
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}
