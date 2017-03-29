package Player.HeroPowers;

import Cards.WhispersOfTheOldGods.Uncollectible.Tokens.SilverHandMurloc;
import Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class TheTidalHand implements HeroPower {

    @Override
    public void Cast(Player player) {
        player.summonCard(new SilverHandMurloc());
    }
}
