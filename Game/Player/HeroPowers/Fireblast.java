package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;

/**
 * Created by Cheech on 3/29/2017. nxs1720@g.rit.edu
 */
public class Fireblast extends HeroPower {

    public Fireblast() {
        super();
    }

    @Override
    public void Cast(Player player, BoardState board) {
        int index = player.promptTargetIndex(board, 0);
        MasterTargeter.Main(player, index, 1, null, false , board);
        wasCast = true;
    }

    @Override
    public String toString() {
        return "Fireblast - Deal 1 damage \nCost " + cost + " mana";
    }
}
