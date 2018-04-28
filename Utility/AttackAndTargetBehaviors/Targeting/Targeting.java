package Utility.AttackAndTargetBehaviors.Targeting;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasElusive;
import Utility.Enchantments.Enchantments.Keywords.HasImmune;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Targeting {

    //Constants
    private static final int HERO = -1;

    // If a minion is attacking use this to check.
    public static boolean minionTargeting(Player target, int index, Minion minion) {
        if (minion.canAttack()) {
            if (thereAreMinions(target)) {
                ArrayList<Integer> taunts = findKeyword(target, new HasTaunt(null));
                if (!taunts.isEmpty()) {
                    return checkTauntMinions(taunts, index, target);
                }
                else if (index == HERO) {
                    return checkImmuneHero(target);
                }
                else {
                    return true;
                }
            }
            else { // there are no minions
                if (index == HERO) { //targeting the hero
                    return checkImmuneHero(target);
                }
                else {
                    System.out.println("There are no minions on the board. (go face pls :(  )");
                    return false;
                }
            }
        }
        else {
            System.out.println("Minion attack failed...");
            return false;
        }
    }

    // Targetting with a spell/battlecry
    public static boolean characterTargeting(Player target, int index, boolean battlecry) {
        if (index == HERO) {
            return checkImmuneHero(target);
        }
        if (thereAreMinions(target)) {
            ArrayList<Integer> elusives = findKeyword(target, new HasElusive(null));
            if (beingElusiveMatters(elusives, battlecry)) {
                return checkElusiveMinions(elusives, index, target);
            }
            else {
                Minion minion = target.getPlayerSide().get(index);
                return checkImmuneMinions(minion);
            }
        }
        else {
            System.out.println("There are no minions on the board. (go face pls :(  )");
            return false;
        }
    }

    private static ArrayList<Integer> findKeyword(Player target, Enchantments enchantments) {
        ArrayList<Integer> minionIndexes = new ArrayList<>();
        for (Minion minion: target.getPlayerSide()) {
            if (minion.checkForEnchantment(enchantments, minion.getEnchantments())) {
                minionIndexes.add(target.getPlayerSide().indexOf(minion));
            }
        }
        return minionIndexes;
    }

    private static boolean checkImmuneHero(Player target) {
        if (target.getHero().checkForEnchantment(new HasImmune(target.getHero()), target.getHero().getEnchantments())) {
            System.out.println("The enemy is immune.");
            return false;
        }
        return true;
    }

    private static boolean checkImmuneMinions(Minion minion) {
        if (minion.checkForEnchantment(new HasImmune(minion), minion.getEnchantments())) {
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
        return checkImmuneMinions(target.getPlayerSide().get(index));
    }

    private static boolean checkTauntMinions(ArrayList<Integer> taunts, int index, Player target) {
        if (taunts.contains(index)) {
            return checkImmuneMinions(target.getPlayerSide().get(index));
        }
        System.out.println("You must attack the minion with taunt!");
        return false;
    }

    private static boolean beingElusiveMatters(ArrayList<Integer> elusives, boolean battlecry) {
        return !(elusives.isEmpty()) && !battlecry;
    }

}
