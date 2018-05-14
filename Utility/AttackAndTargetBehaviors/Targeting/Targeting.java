package Utility.AttackAndTargetBehaviors.Targeting;

import Cards.Structure.Minion;
import Game.Player.Hero;
import Game.Player.Player;
import Game.Targetable;
import Utility.Enchantments.Enchantments.Keywords.HasElusive;
import Utility.Enchantments.Enchantments.Keywords.HasImmune;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Structure.Enchantments;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Targeting {

    //Constants
    private static final int HERO = -1;

    // If a minion is attacking use this to check.
    public static boolean minionTargeting(Targetable target, Minion thisMinion) {
        if (thisMinion.canAttack()) {
            if (thereAreMinions(target.getOwner())) {
                ArrayList<Integer> taunts = findKeyword(target.getOwner(), new HasTaunt(null));
                if (!taunts.isEmpty()) {
                    return checkTauntMinions(taunts, target.getIndex(), target.getOwner());
                }
                else if (target.getIndex() == HERO) {
                    Hero heroTarget = (Hero)(target);
                    return checkImmuneHero(heroTarget);
                }
                else {
                    return true;
                }
            }
            else { // there are no minions
                if (target.getIndex() == HERO) { //targeting the hero
                    Hero heroTarget = (Hero)(target);
                    return checkImmuneHero(heroTarget);
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
    public static boolean characterTargeting(Targetable target, boolean battlecry) {
        if (target.getIndex() == HERO) {
            Hero heroTarget = (Hero)(target);
            return checkImmuneHero(heroTarget);
        }
        if (thereAreMinions(target.getOwner())) {
            ArrayList<Integer> elusives = findKeyword(target.getOwner(), new HasElusive(null));
            if (beingElusiveMatters(elusives, battlecry)) {
                return checkElusiveMinions(elusives, target.getIndex(), target.getOwner());
            }
            else {
                Minion minion = (Minion)(target);
                return checkImmuneMinions(minion);
            }
        }
        else {
            System.out.println("There are no minions on the board. (go face pls :(  )");
            return false;
        }
    }

    private static ArrayList<Integer> findKeyword(Player player, Enchantments enchantments) {
        ArrayList<Integer> minionIndexes = new ArrayList<>();
        for (Minion minion: player.getPlayerSide()) {
            if (minion.checkForEnchantment(enchantments, minion.getEnchantments())) {
                minionIndexes.add(player.getPlayerSide().indexOf(minion));
            }
        }
        return minionIndexes;
    }

    private static boolean checkImmuneHero(Hero target) {
        if (target.checkForEnchantment(new HasImmune(target), target.getEnchantments())) {
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

    private static boolean checkElusiveMinions(ArrayList<Integer> elusives, int index, Player player) {
        if (elusives.contains(index)) {
            System.out.println("You cannot target this minion.");
            return false;
        }
        return checkImmuneMinions(player.getPlayerSide().get(index));
    }

    private static boolean checkTauntMinions(ArrayList<Integer> taunts, int index, Player player) {
        if (taunts.contains(index)) {
            return checkImmuneMinions(player.getPlayerSide().get(index));
        }
        System.out.println("You must attack the minion with taunt!");
        return false;
    }

    private static boolean beingElusiveMatters(ArrayList<Integer> elusives, boolean battlecry) {
        return !(elusives.isEmpty()) && !battlecry;
    }

}
