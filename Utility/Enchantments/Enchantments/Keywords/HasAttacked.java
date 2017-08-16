package Utility.Enchantments.Enchantments.Keywords;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class HasAttacked extends Enchantments {

    public HasAttacked(CanHaveEnchantments link) {
        super(Keywords.HASATTACKED, "Has Already Attacked", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion, Spell spell) {
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}