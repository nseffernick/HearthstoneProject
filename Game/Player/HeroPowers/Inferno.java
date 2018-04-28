package Game.Player.HeroPowers;

import Cards.Classic.Uncollectible.Tokens.Infernal;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Inferno extends HeroPower{

    public Inferno() {
        super();
    }

    @Override
    public void Cast(Player player, int index) {
        player.summonCard(new Infernal());
        wasCast = true;
    }
}
