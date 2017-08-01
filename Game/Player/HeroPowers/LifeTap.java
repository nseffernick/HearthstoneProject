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
    public boolean Cast(Player player, BoardState board) {
        player.getHero().addHp(-2);
        player.drawCard();
        wasCast = true;
        return true;
    }

    @Override
    public String toString() {
        return "Life Tap - Take 2 damage Draw a Card \nCost " + cost + "Mana";
    }
}
