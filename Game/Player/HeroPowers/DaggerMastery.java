package Game.Player.HeroPowers;

import Cards.Expansions.Classic.Uncollectible.Rogue.Weapons.WickedKnife;
import Game.BoardState;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017. nxs1720@g.rit.edu
 */
public class DaggerMastery extends HeroPower {

    public DaggerMastery(Player owner) {
        super(owner);
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        player.getHero().setWeapon(new WickedKnife(player));
        wasCast = true;
        return true;
    }

    @Override
    public String toString() {
        return "Dagger Mastery - Equip a 1/2 Wicked Dagger \nCost " + cost + " Mana";
    }
}
