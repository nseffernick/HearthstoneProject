package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;

/**
 * Created by Cheech on 3/29/2017.
 */
public class LightningJolt extends HeroPower {

    public LightningJolt() {
        super();
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        Player targetPlayer = player.promptTargetPlayer(board);
        int index = player.promptTargetIndex(board, 0);
        if(MasterTargeter.Main(targetPlayer, index, 2, null, false, board)) {
            wasCast = true;
            return true;
        }
        return false;
    }
}
