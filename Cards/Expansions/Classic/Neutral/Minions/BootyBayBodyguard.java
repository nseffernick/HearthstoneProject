package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Booty Bay Bodyguard Minion
 */
public class BootyBayBodyguard extends Minion {

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


    public BootyBayBodyguard(Player owner) {

        super(4, 5, 5, "Booty Bay Bodyguard", owner,"Taunt", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.TAUNT);
    }

}