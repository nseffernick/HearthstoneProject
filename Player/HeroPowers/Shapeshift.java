package Player.HeroPowers;

import Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Shapeshift implements HeroPower {

    @Override
    public void Cast(Player player) {
        player.getHero().atk += 1; player.getHero().armor += 1;
    }
}
