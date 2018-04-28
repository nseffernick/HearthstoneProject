package Game.Player.HeroPowers;

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
    public void Cast(Player player, int index) {
        MasterTargeter.Main(player, index, 1, null);
        wasCast = true;
    }
}
