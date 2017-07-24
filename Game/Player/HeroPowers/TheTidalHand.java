package Game.Player.HeroPowers;

import Cards.WhispersOfTheOldGods.Uncollectible.Tokens.SilverHandMurloc;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class TheTidalHand extends HeroPower {

    public TheTidalHand() {
        super();
    }

    @Override
    public void Cast(Player player, int index) {
        player.summonCard(new SilverHandMurloc());
        wasCast = true;
    }
}
