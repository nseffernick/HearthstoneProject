package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Enchantments.Structure.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Bluegill Warrior Minion
 */
public class BluegillWarrior extends Minion {

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

    public BluegillWarrior(Player owner) {

        super(1, 2, 2, "Bluegill Warrior", owner, "Charge", Rarity.BASIC,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.CHARGE);
    }

}