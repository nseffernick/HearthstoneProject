package Utility.AttackAndTargetBehaviors.Targeting;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Targeting {

    // If a minion is attacking use this to check.
    public static boolean minionTargeting(Player target, int index) {
        if (thereAreMinions(target)) {
            ArrayList<Integer> taunts = findKeyword(target, Keywords.TAUNT);
            if (!taunts.isEmpty()) {
                return checkTauntMinions(taunts, index, target);
            }
            if (index == -1) {
                return checkImmuneHero(target);
            }
            else {
                System.out.println("There is no minion at that index!");
                return false;
            }
        }
        else {
            if (index == -1) {
                return checkImmuneHero(target);
            }
            else {
                System.out.println("You must go FACE!");
                return false;
            }
        }
    }

    public static boolean characterTargeting(Player target, int index, boolean battlecry) {
        if (thereAreMinions(target)) {
            ArrayList<Integer> elusives = findKeyword(target, Keywords.ELUSIVE);
            if (beingElusiveMatters(elusives, battlecry)) {
                return checkElusiveMinions(elusives, index, target);
            }
            if (index >= -1 || index <= target.getPlayerSide().size() - 1) {
                if (index == -1) {
                    return checkImmuneHero(target);
                }
                else {
                    return checkImmuneMinions(target, index);
                }
            }
            else {
                System.out.println("There is no minion at that index!");
                return false;
            }
        }
        else {
            if (index == -1) {
                return checkImmuneHero(target);
            }
            else {
                System.out.println("You must go FACE!");
                return false;
            }
        }
    }

    private static ArrayList<Integer> findKeyword(Player target, Keywords keyword) {
        ArrayList<Integer> minionIndexes = new ArrayList<>();
        for (Minion minion: target.getPlayerSide()) {
            if (minion.getProperties().contains(keyword)) {
                minionIndexes.add(target.getPlayerSide().indexOf(minion));
            }
        }
        return minionIndexes;
    }

    private static boolean checkImmuneHero(Player target) {
        if (target.getHero().getProperties().contains(Keywords.IMMUNE)) {
            System.out.println("The enemy is immune.");
            return false;
        }
        return true;
    }

    private static boolean checkImmuneMinions(Player target, int index) {
        if (target.getPlayerSide().get(index).getProperties()
                .contains(Keywords.IMMUNE)) {
            System.out.println("The enemy is immune.");
            return false;
        }
        return true;
    }

    private static boolean thereAreMinions(Player target) {
        return !(target.getPlayerSide().isEmpty());
    }

    private static boolean checkElusiveMinions(ArrayList<Integer> elusives, int index, Player target) {
        if (elusives.contains(index)) {
            System.out.println("You cannot target this minion.");
            return false;
        }
        return checkImmuneMinions(target, index);
    }

    private static boolean checkTauntMinions(ArrayList<Integer> taunts, int index, Player target) {
        if (taunts.contains(index)) {
            return checkImmuneMinions(target, index);
        }
        System.out.println("You must attack the minion with taunt!");
        return false;
    }

    private static boolean beingElusiveMatters(ArrayList<Integer> elusives, boolean battlecry) {
        return !(elusives.isEmpty()) && !battlecry;
    }

}
