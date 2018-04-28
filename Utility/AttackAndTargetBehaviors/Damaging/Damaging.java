package Utility.AttackAndTargetBehaviors.Damaging;

import Cards.Minion;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017. nxs1720@g.rit.edu
 * -- Fixed healing on 6/23/17 by ME
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
            // if the hero is getting healed
            if (dmg < 0) {
                if (target.getHero().getHp() - dmg >
                        target.getHero().getMaxHP()) {
                    dmg = target.getHero().getMaxHP() -
                            target.getHero().getHp();
                }
                target.getHero().addHp(dmg);
            }
            else {
                target.getHero().addHp(-dmg);
            }
        }
        else {
            // If the character is getting healed
            if (dmg < 0) {
                if (target.getPlayerSide().get(index).getHp() - dmg >
                        target.getPlayerSide().get(index).getMaxHP()) {
                    dmg = target.getPlayerSide().get(index).getMaxHP() -
                            target.getPlayerSide().get(index).getHp();
                }
                target.getPlayerSide().get(index).addHp(dmg);
            }
            else {
                target.getPlayerSide().get(index).addHp(-dmg);
            }
        }
    }
    
    public static void minionCombat(Player target, int index, Minion minion) {
        if (index < 0) {
            target.getHero().addHp(-minion.getAtk());
        }
        else {
            target.getPlayerSide().get(index).addHp(-minion.getAtk());
            minion.addHp(-target.getPlayerSide().get(index).getAtk());
        }
    }

}
