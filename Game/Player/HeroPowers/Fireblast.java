package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.UtilityMethods.UtilityMethods;

/**
 * Created by Cheech on 3/29/2017. nxs1720@g.rit.edu
 */
public class Fireblast extends HeroPower {

    public Fireblast() {
        super();
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        Player targetPlayer = player.promptTargetPlayer(board);
        int index = player.promptTargetIndex(board, 0);
        if (MasterTargeter.Main(targetPlayer, index, 1, null, false , board)) {
            wasCast = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Fireblast - Deal 1 damage \nCost " + cost + " mana";
    }
}
