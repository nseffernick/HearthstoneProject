package Utility.Enchantments.Enchantments.Keywords;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class HasTaunt extends Enchantments {

    public HasTaunt(CanHaveEnchantments link) {
        super(Keywords.TAUNT, "Taunt", link);
    }

    @Override
    public void enchant(BoardState board, Minion minion, Spell spell) {
    }

    @Override
    public void disenchant(BoardState board, Minion minion) {
    }
}