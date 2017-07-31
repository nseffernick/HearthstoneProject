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
    public void Cast(Player player, BoardState board) {
        int index = player.promptTargetIndex(board, 0);
        MasterTargeter.Main(player, index, 2, null, false, board);
    }

    @Override
    public String toString() {
        return "Mind Blast - Deal 2 damage \nCost " + cost + " mana";
    }
}
