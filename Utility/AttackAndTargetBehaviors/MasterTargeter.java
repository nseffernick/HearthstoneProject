package Utility.AttackAndTargetBehaviors;

import Cards.Structure.Card;
import Game.BoardState;
import Game.Player.Player;
import Cards.Structure.Minion;
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

    public static void Main(Player player, int index, int dmg,
                            Minion minion, boolean battlecry, BoardState board) {
        if (dmg == 0) {
            if (Targeting.minionTargeting(player, index, minion)) {
                Damaging.minionCombat(player, index, minion, board);
            }
            else {
                // do something here to allow them to still target
                // something else
            }
        }
        else {
            if (Targeting.characterTargeting(player, index, battlecry)) {
                Damaging.damageCharacter(player, index, dmg, board);
            }
            else {
                // do something here to allow them to still target
                // something else
            }
        }
    }

    public static void TargetAll(boolean withHero, Player player, int dmg, BoardState board) {
        if (withHero) {
            Damaging.damageCharacter(player, -1, dmg, board);
        }
        for (int i = 0; i < player.getPlayerSide().size() - 1; i++) {
            Damaging.damageCharacter(player, i, dmg, board);
        }
    }

    public static LinkedList<Card> CustomTarget(Player player, String where,
                                                Tribe tribe, Minion link) {

        LinkedList<Card> collection = new LinkedList<>();

        if (player == null) {

        }
        else {
            LinkedList<Card> side = new LinkedList<>();
            if (where.equals("Board")) {
                side.addAll(player.getPlayerSide());
            }
            else if (where.equals("Hand")) {
                side.addAll(player.getHand());
            }
            for(int i = 0; i < side.size(); i++) {
                if (side.get(i) == link); // is the minion the one with the aura
                else {
                    if (tribe == null) {
                        collection.add(side.get(i));
                    }
                    else {
                        if (side.get(i) instanceof Minion) {
                            Minion minion = (Minion) side.get(i);
                            if (minion.getTribe() == tribe) {
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
