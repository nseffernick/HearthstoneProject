package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;

/**
 * Created by Cheech on 3/29/2017.
 */
public class LesserHeal extends HeroPower {

    public LesserHeal() {
        super();
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        Player targetPlayer = player.promptTargetPlayer(board);
        int index = player.promptTargetIndex(board, 0);
        if (MasterTargeter.Main(targetPlayer, index, -2, null, false, board)) {
            wasCast = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Lesser Heal - Restore 2 hp \nCost " + cost + " Mana";
    }
}
