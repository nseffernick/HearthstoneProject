package Player.HeroPowers;

import Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class LifeTap implements HeroPower {
    @Override
    public void Cast(Player player) {
        player.getHero().hp -= 2;
        player.drawCard();
    }
}
