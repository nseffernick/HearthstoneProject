package Utility.AttackAndTargetBehaviors;

import Cards.Card;
import Game.Player.Player;
import Cards.Minion;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;
import Utility.Tribes.Tribe;

import java.util.LinkedList;

/**
 * Created by Cheech on 3/30/2017. nxs1720
 * All things targeting and damaging
 *
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

    public static void TargetAll(boolean withHero, Player player, int dmg) {
        if (withHero) {
            Damaging.damageCharacter(player, -1, dmg);
        }
        for (int i = 0; i < player.getPlayerSide().size() - 1; i++) {
            Damaging.damageCharacter(player, i, dmg);
        }
    }

    public static LinkedList<Minion> CustomTarget(Player player, String where,
                                                Tribe tribe, Minion link) {

        LinkedList<Minion> collection = new LinkedList<>();

        if (player == null) {

        }
        else {
            if (where.equals("Board")) {
                LinkedList<Minion> side = player.getPlayerSide();
                for(int i = 0; i < side.size(); i++) {
                    if (side.get(i) == link); // is the minion the one with the aura
                    else {
                        if (tribe == null) {
                            collection.add(side.get(i));
                        }
                        else {
                            if (side.get(i).getTribe() == tribe) {
                                collection.add(side.get(i));
                            }
                        }
                    }
                }
            }
        }
        return collection;
    }
}
