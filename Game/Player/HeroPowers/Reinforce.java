package Game.Player.HeroPowers;

import Cards.Expansions.Classic.Uncollectible.Tokens.SilverHand;
import Game.BoardState;
import Game.Player.Player;

/**
 * Created by Cheech on 3/29/2017.
 */
public class Reinforce extends HeroPower {

    public Reinforce() {
        super();
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        player.summonCard(new SilverHand(player), board);
        wasCast = true;
        return true;
    }

    public String toString() {
        return "Reinforce - Summon a 1/1 Silver Hand Recruit \nCost two mana";
    }
}
