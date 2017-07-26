package Game.Player.HeroPowers;

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
    public void Cast(Player player, int index) {
        MasterTargeter.Main(player, index, 2, null, false);
        wasCast = true;
    }
}
