package Player.HeroPowers;

import Cards.Classic.Uncollectible.Tokens.SilverHand;
import Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Reinforce implements HeroPower {

    @Override
    public void Cast(Player player) {
        player.summonCard(new SilverHand());
    }
}
