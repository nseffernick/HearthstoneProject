package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;

/**
 * Created by Cheech on 3/29/2017.
 */
public class MindSpike extends HeroPower {

    public MindSpike() {
        super();
    }

    @Override
    public void Cast(Player player, int index, BoardState board) {
        MasterTargeter.Main(player, index, 2, null, false, board);
    }
}
