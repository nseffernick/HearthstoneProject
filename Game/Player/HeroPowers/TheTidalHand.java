package Game.Player.HeroPowers;

import Cards.Expansions.WhispersOfTheOldGods.Uncollectible.Tokens.SilverHandMurloc;
import Game.BoardState;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class TheTidalHand extends HeroPower {

    public TheTidalHand() {
        super();
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        player.summonCard(new SilverHandMurloc(player), board);
        wasCast = true;
        return true;
    }
}
