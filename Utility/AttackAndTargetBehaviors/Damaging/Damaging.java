package Utility.AttackAndTargetBehaviors.Damaging;

import Cards.Minion;
import Player.Player;
import Utility.Keywords.Keywords;

/**
 * Created by Cheech on 3/29/2017. nxs1720@g.rit.edu
 */
public class Damaging {

    /**
     * For now will be only for things that deal damage,
     * and can target anything, so fireblast and a lot of spells.
     *
     * @param target
     * @param index
     * @param dmg
     */
    public static void damageCharacter(Player target, int index, int dmg) {
        if (index < 0) {
            if (dmg < 0) {
                // if the character is getting healed
                if (dmg + target.getHero().hp >
                        target.getHero().maxHP) {
                    dmg = target.getHero().maxHP -
                            target.getHero().hp;
                }
                target.getHero().hp -= dmg;
            }
            if (index >= 0 || index <= target.getPlayerSide().size() - 1) {
                // If the character is getting healed
                if (dmg < 0) {
                    if (dmg + target.getPlayerSide().get(index).hp >
                            target.getPlayerSide().get(index).maxHP) {
                        dmg = target.getPlayerSide().get(index).maxHP -
                                target.getPlayerSide().get(index).hp;
                    }
                    target.getPlayerSide().get(index).hp -= dmg;
                } else {
                    target.getPlayerSide().get(index).hp -= dmg;
                }
            }
        }
    }
    
    public static void minionCombat(Player target, int index, Minion minion) {
        if (index < 0) {
            target.getHero().hp -= minion.getAtk();
        }
        else {
            target.getPlayerSide().get(index).hp -= minion.getAtk();
            minion.hp -= target.getPlayerSide().get(index).getAtk();
        }
    }

}
