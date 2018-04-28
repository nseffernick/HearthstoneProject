package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;

/**
 * Created by Cheech on 3/29/2017.
 */
public class SteadyShot extends HeroPower{

    public SteadyShot() {
        super();
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        if(MasterTargeter.Main(player, -1, 2, null, false, board)) {
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
