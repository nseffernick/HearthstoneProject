package Player.HeroPowers;

import Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;

/**
 * Created by Cheech on 3/29/2017.
 */
public class MindShatter implements HeroPower {
    @Override
    public void Cast(Player player, int index) {
        MasterTargeter.Main(player, index, 2, null);
    }
}
