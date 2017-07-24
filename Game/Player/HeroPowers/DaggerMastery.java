package Game.Player.HeroPowers;

import Cards.Classic.Uncollectible.Weapons.WickedKnife;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017. nxs1720@g.rit.edu
 */
public class DaggerMastery extends HeroPower {

    @Override
    public void Cast(Player player, int index) {
        player.getHero().setWeapon(new WickedKnife());
        wasCast = true;
    }
    public DaggerMastery() {
        super();
    }

}
