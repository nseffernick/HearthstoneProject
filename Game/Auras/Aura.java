package Game.Auras;

import Cards.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Keywords.Keywords;
import Utility.Tribes.Tribe;

/**
 * Created by Cheech on 4/5/2017.
 * An on-going status effect
 *
 * Has Strings that determine how each aura will affect the board.
 * Where will say all enemies, all friendlies, both hands, your deck, etc..
 * Effect will say decrease attack, increase cost, improve stats, etc..
 */
public abstract class Aura {

    // State
    protected static Minion link;
    protected String name;
    protected String where;
    protected String effect;
    protected Tribe tribe;
    protected boolean adjacent;

    public Aura(Minion link, String name) {
        this.link = link;
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public String getWhere() {
        return where;
    }

    public String getEffect() {
        return effect;
    }

    public Tribe getTribe() {
        return tribe;
    }

    public boolean getAdjacent() {
        return adjacent;
    }

    public Minion getLink() {
        return link;
    }

    public String getName() { return name;}
}
