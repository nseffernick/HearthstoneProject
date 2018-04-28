package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;

/**
 * Created by Cheech on 3/29/2017.
 */
public class MindShatter extends HeroPower {

    public MindShatter() {
        super();
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        Player targetPlayer = player.promptTargetPlayer(board, ANY_TARGET);
        int index = player.promptTargetIndex(board, targetPlayer);
        if(MasterTargeter.Main(targetPlayer, index, 3, null, false, board)) {
            wasCast = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Mind Shatter - Deal 3 damage \nCost " + cost + " mana";
    }
}
