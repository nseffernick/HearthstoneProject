package Game.Player.HeroPowers;

import Cards.Classic.Uncollectible.Tokens.SilverHand;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Reinforce extends HeroPower {

    public Reinforce() {
        super();
    }

    @Override
    public void Cast(Player player, int index) {
        player.summonCard(new SilverHand(player));
        wasCast = true;
    }
}
