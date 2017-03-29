package Player.HeroPowers;

import Player.Player;

/**
 * Created by Cheech on 3/29/2017. nxs1720@g.rit.edu
 */
public class Fireblast implements HeroPower {
    @Override
    public void Cast(Player player) {
        int index = 1;
        player.damageCharacter(player, index, 1);
    }
}
