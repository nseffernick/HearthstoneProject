package Cards.Structure;

import Utility.Enchantments.Structure.Keywords;

public interface BenefitsFromSpellDamage {

    default int calcSpellDamage(Spell spell) {
        int moreDamage = 0;
        for (Minion minion: spell.getOwner().getPlayerSide()) {
            for (Keywords keyword: minion.getEnchantments()) {
                if (keyword == Keywords.SPELLDAMAGE) {
                    moreDamage += 1;
                }
            }
        }
        return moreDamage;
    }
}
