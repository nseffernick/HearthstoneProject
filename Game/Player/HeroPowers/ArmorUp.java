package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 * Gain 2 Armor
 */
public class ArmorUp extends HeroPower {

    public ArmorUp() {
        super();
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        player.getHero().addArmor(2);
        wasCast = true;
        return true;
    }

    @Override
    public String toString() {
        return "Armor Up - Gain 2 Armor \nCost " + cost + " Mana";
    }
}
