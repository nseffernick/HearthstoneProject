package Utility.AttackAndTargetBehaviors.Damaging;

import Cards.Structure.Minion;
import Game.Player.Hero;
import Game.Targetable;
import Utility.Enchantments.Enchantments.Keywords.HasImmune;

/**
 * Created by Cheech on 3/29/2017. nxs1720@g.rit.edu
 * -- Fixed healing on 6/23/17 by ME
 */
public class Damaging {

    //Constants

    private static final int HERO = -1;

    /**
     * For now will be only for things that deal damage,
     * and can target anything, so fireblast and a lot of spells.
     *
     * @param dmg
     * @param target
     */
    public static void damageCharacter(int dmg, Targetable target) {
        if (target.getIndex() == HERO) {
            Hero heroTarget = (Hero)(target);
            if (heroTarget.getEnchantments().contains(new HasImmune(null))) {
                heroTarget.addHp(-dmg);
            }
        }
        else { // Is a minion
            Minion minionTarget = (Minion)(target);
            if (!minionTarget.getEnchantments().contains(new HasImmune(null))) {
                minionTarget.addHp(-dmg);
            }
        }
    }
    
    public static void minionCombat(Targetable target, Minion minion) {
        if (target.getIndex() == HERO) {
            Hero heroTarget = (Hero)(target);
            heroTarget.addHp(-minion.getAtk());
        }
        else {
            int atkingDmg = -minion.getAtk();
            int defendingDmg = -target.getAtk();
            target.addHp(atkingDmg);
            minion.addHp(defendingDmg);
        }
    }

}
