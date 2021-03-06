package Game.Player.HeroPowers;

import Cards.Expansions.Classic.Uncollectible.Warlock.Minions.Infernal;
import Game.BoardState;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Inferno extends HeroPower{

    public Inferno(Player owner) {
        super(owner);
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        player.summonMinion(new Infernal(player), board);
        wasCast = true;
        return true;
    }
}
