package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.UtilityMethods.UtilityMethods;

/**
 * Created by Cheech on 3/29/2017.
 */
public class SteadyShot extends HeroPower{

    public SteadyShot(Player owner) {
        super(owner);
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        if (MasterTargeter.Main(
                2, null, false, UtilityMethods.findEnemy(board, getOwner()).getHero())) {
            wasCast = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Steady Shot - Deal 2 damage to the enemy hero \nCost " + cost + " mana";
    }
}
