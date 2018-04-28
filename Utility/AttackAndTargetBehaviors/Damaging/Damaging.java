package Utility.AttackAndTargetBehaviors.Damaging;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
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
     * @param target
     * @param index
     * @param dmg
     */
    public static void damageCharacter(Player target, int index, int dmg, BoardState board) {
        if (index == HERO) {
            if (!target.getHero().getEnchantments().contains(new HasImmune(null))) {
                target.getHero().addHp(-dmg);
            }
        }
        else { // Is a minion
            if (!target.getPlayerSide().get(index).getEnchantments().contains(new HasImmune(null))) {
                target.getPlayerSide().get(index).addHp(-dmg);
            }
        }
    }
    
    public static void minionCombat(Player target, int index, Minion minion, BoardState board) {
        if (index == HERO) {
            target.getHero().addHp(-minion.getAtk());
        }
        else {
            int atkingDmg = -minion.getAtk();
            int defendingDmg = -target.getPlayerSide().get(index).getAtk();
            target.getPlayerSide().get(index).addHp(atkingDmg);
            minion.addHp(defendingDmg);
        }
    }

}
