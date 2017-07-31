package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;

/**
 * ME 3/19/17
 */
public abstract class HeroPower {

    protected int cost;
    protected boolean wasCast;

    public HeroPower() {
        this.cost = 2;
        this.wasCast = false;
    }

    public int getCost() {
        return cost;
    }

    public boolean getWasCast() {
        return wasCast;
    }

    public abstract void Cast(Player player, BoardState board);

}