package Cards.Structure;

import Utility.Keywords.Keywords;

public interface benefitsFromSpellDamage {

    default int calcSpellDamage(Spell spell) {
        int moreDamage = 0;
        for (Minion minion: spell.getOwner().getPlayerSide()) {
            for (Keywords keyword: minion.getProperties()) {
                if (keyword == Keywords.SPELLDAMAGE) {
                    moreDamage += 1;
                }
            }
        }
        return moreDamage;
    }
}
