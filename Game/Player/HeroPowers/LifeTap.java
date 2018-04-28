package Game.Player.HeroPowers;

import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class LifeTap extends HeroPower {

    public LifeTap() {
        super();
    }

    @Override
    public void Cast(Player player, int index) {
        player.getHero().setHp(-2);
        player.drawCard();
        wasCast = true;
    }
}
