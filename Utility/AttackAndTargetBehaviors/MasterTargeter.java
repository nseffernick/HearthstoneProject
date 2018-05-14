package Utility.AttackAndTargetBehaviors;

import Game.BoardState;
import Game.Player.Player;
import Cards.Structure.Minion;
import Game.Targetable;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;

/**
 * Created by Cheech on 3/30/2017. nxs1720
 * All things targeting and damaging
 *
 */
public class MasterTargeter {

    public static boolean Main(int dmg, Minion minion, boolean battlecry, Targetable target) {
        if (dmg == 0) {
            if (Targeting.minionTargeting(target, minion)) {
                Damaging.minionCombat(target, minion);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (Targeting.characterTargeting(target, battlecry)) {
                Damaging.damageCharacter(dmg, target);
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static void TargetAll(boolean withHero, Player player, int dmg, BoardState board) {
        if (withHero) {
            Damaging.damageCharacter(dmg, player.getHero());
        }
        for (int i = 0; i < player.getPlayerSide().size(); i++) {
            Damaging.damageCharacter(dmg, player.getPlayerSide().get(i));
        }
    }

}
