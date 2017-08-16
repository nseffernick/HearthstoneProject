package Utility.Enchantments.Enchantments.Battlecries;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;
import Utility.Enchantments.Structure.TemporaryEnchantment;

public class AbusiveBuff extends Enchantments implements TemporaryEnchantment {

    public AbusiveBuff(CanHaveEnchantments link) {
        super(Keywords.ENDOFYOURTURN, "+2 Temporary Attack", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion, Spell spell) {
        if (link instanceof Minion) {
            Minion minionLink = (Minion) link;
            minionLink.addAtk(2);
        }
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
        if (link instanceof Minion) {
            Minion minionLink = (Minion) link;
            minionLink.addAtk(-2);
        }
    }

    @Override
    public void temporaryDisenchant(BoardState board, Minion minion) {
        disenchant(board, minion);
    }
}
