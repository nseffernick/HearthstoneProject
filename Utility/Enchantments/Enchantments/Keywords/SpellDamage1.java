package Utility.Enchantments.Enchantments.Keywords;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class SpellDamage1 extends Enchantments {

    public SpellDamage1(CanHaveEnchantments link) {
        super(Keywords.SPELLDAMAGE, "Spell Damage +1", link);
    }

    @Override
    public void enchant(BoardState board, Minion minion, Spell spell) {
    }

    @Override
    public void disenchant(BoardState board, Minion minion) {
    }
}
