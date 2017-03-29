package Player.HeroPowers;

import Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class MindShatter implements HeroPower {
    @Override
    public void Cast(Player player) {
        player.damageCharacter(player, 1, 3);
    }
}
