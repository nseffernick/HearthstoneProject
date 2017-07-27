package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Shapeshift extends HeroPower {

    public Shapeshift() {
        super();
    }

    @Override
    public void Cast(Player player, int index, BoardState board) {
        player.getHero().addAtk(1);
        player.getHero().addArmor(1);
        wasCast = true;
    }
}
