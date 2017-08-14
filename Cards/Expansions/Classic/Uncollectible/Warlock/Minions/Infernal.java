package Cards.Expansions.Classic.Uncollectible.Warlock.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/27/2017. nxs1720@g.rit.edu
 */
public class Infernal extends Minion {

    // State
    protected int hp;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Keywords> properties;

    public Infernal(Player owner) {

        super(6, 6, 6, "Infernal", owner,"", Rarity.BASIC,
                Tribe.DEMON, HeroClass.WARLOCK, new ArrayList<Keywords>());
    }
}
