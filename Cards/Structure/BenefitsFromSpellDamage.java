package Cards.Structure;

import Utility.Enchantments.Enchantments.Keywords.SpellDamage1;
import Utility.Enchantments.Structure.Enchantments;

public interface BenefitsFromSpellDamage {

    default int calcSpellDamage(Spell spell) {
        int moreDamage = 0;
        for (Minion minion: spell.getOwner().getPlayerSide()) {
            for (Enchantments enchantments: minion.getEnchantments()) {
                if (enchantments instanceof SpellDamage1) {
                    moreDamage += 1;
                }
            }
        }
        return moreDamage;
    }
}
