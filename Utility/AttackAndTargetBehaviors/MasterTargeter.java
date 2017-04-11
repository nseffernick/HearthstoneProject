package Utility.AttackAndTargetBehaviors;

import Player.Player;
import Cards.Minion;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;

/**
 * Created by Cheech on 3/30/2017. nxs1720
 */
public class MasterTargeter {

    public static void Main(Player player, int index,
                            int dmg, Minion minion) {
        if (dmg == 0) {
            if (Targeting.minionTargeting(player, index)) {
                Damaging.minionCombat(player, index, minion);
            }
            else {
                // do something here to allow them to still target
                // something else
            }
        }
        else {
            if (Targeting.characterTargeting(player, index)) {
                Damaging.damageCharacter(player, index, dmg);
            }
            else {
                // do something here to allow them to still target
                // something else
            }
        }
    }
}
