package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;

/**
 * Created by Cheech on 3/29/2017.
 */
public class MindSpike extends HeroPower {

    public MindSpike(Player owner) {
        super(owner);
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        Player targetPlayer = player.promptTargetPlayer(board, ANY_TARGET);
        int index = player.promptTargetIndex(board, targetPlayer);
        if (MasterTargeter.Main(2, null, false, )) {
            wasCast = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Mind Spike - Deal 2 damage \nCost " + cost + " mana";
    }
}
