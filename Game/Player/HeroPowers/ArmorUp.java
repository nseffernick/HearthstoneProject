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
    public void Cast(Player player, int index, BoardState board) {
        player.getHero().addArmor(2);
        wasCast = true;
    }

}
