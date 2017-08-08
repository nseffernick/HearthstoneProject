package Utility.AttackAndTargetBehaviors.Damaging;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Keywords.Keywords;

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
    public static void damageCharacter(Player target, int index, int dmg, BoardState board) {
        if (index == -1) {
            if (!target.getHero().getProperties().contains(Keywords.IMMUNE)) {
                target.getHero().addHp(target, -dmg);
            }
        }
        else {
            if (!target.getPlayerSide().get(index).getProperties().contains(Keywords.IMMUNE)) {
                target.getPlayerSide().get(index).addHp(-dmg, board);
            }
        }
    }
    
    public static void minionCombat(Player target, int index, Minion minion, BoardState board) {
        if (index == -1) {
            target.getHero().addHp(target, -minion.getAtk());
        }
        else {
            int atkingDmg = -minion.getAtk();
            int defendingDmg = -target.getPlayerSide().get(index).getAtk();
            target.getPlayerSide().get(index).addHp(atkingDmg, board);
            minion.addHp(defendingDmg, board);
        }
    }

}
