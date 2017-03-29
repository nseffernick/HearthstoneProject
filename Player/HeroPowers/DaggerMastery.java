package Player.HeroPowers;

import Cards.Classic.Uncollectible.Weapons.WickedKnife;
import Player.Player;

/**
 * Created by Cheech on 3/29/2017. nxs1720@g.rit.edu
 */
public class DaggerMastery implements HeroPower {
    @Override
    public void Cast(Player player) {
        player.getHero().weapon = new WickedKnife();
    }
}
