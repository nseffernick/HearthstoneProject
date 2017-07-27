package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Sen'Jin Shieldmaster Minion
 */
public class SenJinShieldmaster extends Minion {

    // State
    protected int hp = 5;
    protected int atk = 3;
    protected int cost = 4;
    protected String name = "Sen'Jin Shieldmaster";
    protected String text = "Taunt";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public SenJinShieldmaster(Player owner) {

        super(5, 3, 4, "Sen'Jin Shieldmaster", owner,"Taunt", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.TAUNT);
    }

}