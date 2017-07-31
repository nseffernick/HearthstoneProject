package Game.Player.HeroPowers;

import Cards.Expansions.Classic.Uncollectible.Tokens.Infernal;
import Game.BoardState;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Inferno extends HeroPower{

    public Inferno() {
        super();
    }

    @Override
    public void Cast(Player player, BoardState board) {
        player.summonCard(new Infernal(player));
        wasCast = true;
    }
}
