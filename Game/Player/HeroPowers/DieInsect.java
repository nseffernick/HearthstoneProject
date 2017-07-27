package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;

/**
 * Created by Cheech on 3/29/2017.
 */
public class DieInsect extends HeroPower{

    public DieInsect() {
        super();
    }

    @Override
    public void Cast(Player player, int index, BoardState board) {
        int random = player.getRng().randomNum(player.getPlayerSide().size());
        MasterTargeter.Main(player, random, 8, null, false, board);
        wasCast = true;
    }
}
