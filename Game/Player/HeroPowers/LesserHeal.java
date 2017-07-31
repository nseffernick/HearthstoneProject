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
    public void Cast(Player player, BoardState board) {
        int index = player.promptTargetIndex(board, 0);
        MasterTargeter.Main(player, index, -2, null, false, board);
        wasCast = true;
    }

    @Override
    public String toString() {
        return "Lesser Heal - Restore 2 hp \nCost " + cost + " Mana";
    }
}
