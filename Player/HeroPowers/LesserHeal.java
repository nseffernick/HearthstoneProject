package Player.HeroPowers;

import Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class LesserHeal implements HeroPower {
    @Override
    public void Cast(Player player) {
        int index = 1;
        player.damageCharacter(player, index, -2);
    }
}
