package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class LifeTap extends HeroPower {

    public LifeTap() {
        super();
    }

    @Override
    public void Cast(Player player, int index, BoardState board) {
        player.getHero().addHp(-2);
        player.drawCard();
        wasCast = true;
    }
}
