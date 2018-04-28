package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;

/**
 * ME 3/19/17
 */
public abstract class HeroPower {

    //Constants
    protected final int ANY_TARGET = 0;
    protected final int FRIENDLY_TARGET = 1;
    protected final int ENEMY_TARGET = 2;
    protected final int HERO_TARGET = -1;
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

    public void refreshHeroPower() { wasCast = false; }

    public abstract boolean Cast(Player player, BoardState board);

}