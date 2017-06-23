package Utility.AttackAndTargetBehaviors.Targeting;

import Cards.Minion;
import Game.Player.Player;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Targeting {

    // State

    // If a minion is attacking use this to check.
    public static boolean minionTargeting(Player target, int index) {
        if (!(target.getPlayerSide().isEmpty())) {
            ArrayList<Integer> taunts = findKeyword(target, Keywords.TAUNT);
            if (!(taunts.isEmpty())) {
                if (taunts.contains(index)) {
                    return true;
                }
                System.out.println("You must attack the minion with taunt!");
                return false;
            }
            if (index >= -1 || index <= target.getPlayerSide().size()) {
                if (index == -1) {
                    if (target.getHero().getProperties().contains(Keywords.IMMUNE)) {
                        System.out.println("The enemy is immune.");
                        return false;
                    }
                }
                return true;
            }
            else {
                System.out.println("There is no minion at that index!");
                return false;
            }
        }
        else {
            if (index == -1) {
                if (target.getHero().getProperties().contains(Keywords.IMMUNE)) {
                    System.out.println("The enemy is immune.");
                    return false;
                }
                return true;
            }
            else {
                System.out.println("You must go FACE!");
                return false;
            }
        }
    }

    public static boolean characterTargeting(Player target, int index) {
        if (!(target.getPlayerSide().isEmpty())) {
            ArrayList<Integer> elusives = findKeyword(target, Keywords.ELUSIVE);
            if (!(elusives.isEmpty())) {
                if (elusives.contains(index)) {
                    System.out.println("You cannot target this minion.");
                    return false;
                }
                return true;
            }
            if (index >= -1 || index <= target.getPlayerSide().size()) {
                if (index == -1) {
                    if (target.getHero().getProperties().contains(Keywords.IMMUNE)) {
                        System.out.println("The enemy is immune.");
                        return false;
                    }
                }
                if (target.getPlayerSide().get(index).getProperties()
                        .contains(Keywords.IMMUNE)) {
                    System.out.println("The enemy is immune.");
                    return false;
                }
                return true;
            }
            else {
                System.out.println("There is no minion at that index!");
                return false;
            }
        }
        else {
            if (index == -1) {
                if (target.getHero().getProperties().contains(Keywords.IMMUNE)) {
                    System.out.println("The enemy is immune.");
                    return false;
                }
                return true;
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
}
