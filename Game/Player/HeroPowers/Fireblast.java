package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;

/**
 * Created by Cheech on 3/29/2017. nxs1720@g.rit.edu
 */
public class Fireblast extends HeroPower {

    public Fireblast(Player owner) {
        super(owner);
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        Player targetPlayer = player.promptTargetPlayer(board, ANY_TARGET);
        int index = player.promptTargetIndex(board, targetPlayer);
        if (MasterTargeter.Main(1, null, false, )) {
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
