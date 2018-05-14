package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;

/**
 * Created by Cheech on 3/29/2017.
 */
public class DieInsect extends HeroPower{

    public DieInsect(Player owner) {
        super(owner);
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        int random = player.getRng().randomNum(player.getPlayerSide().size());
        if (MasterTargeter.Main(8, null, false, )) {
            wasCast = true;
            return true;
        }
        return false;
    }
}
