package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Shapeshift extends HeroPower {

    public Shapeshift(Player owner) {
        super(owner);
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        player.getHero().addAtk(1);
        player.getHero().addArmor(1);
        wasCast = true;
        return true;
    }

    @Override
    public String toString() {
        return "Shapeshift - Gain 1 attack Gain 1 Armor \nCost " + cost + " mana";
    }
}
