package Game.Player.HeroPowers;

import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Shapeshift extends HeroPower {

    public Shapeshift() {
        super();
    }

    @Override
    public void Cast(Player player, int index) {
        player.getHero().setAtk(1);
        player.getHero().setArmor(1);
        wasCast = true;
    }
}
