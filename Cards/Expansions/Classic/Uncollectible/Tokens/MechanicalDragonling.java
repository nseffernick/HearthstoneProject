package Cards.Expansions.Classic.Uncollectible.Tokens;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 6/26/2017.
 */
public class MechanicalDragonling extends Minion {

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

    public MechanicalDragonling(Player owner) {

        super(1, 2, 1, "Mechanical Dragonling", owner,"", Rarity.BASIC,
                Tribe.MECH, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }
}
