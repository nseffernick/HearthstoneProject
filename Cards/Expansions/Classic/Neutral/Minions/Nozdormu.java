package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Nozdormu extends Minion {

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

    public Nozdormu(Player owner) {

        super(8, 8, 9, "Nozdormu", owner,"Players only have 15 seconds to take their turns.", Rarity.LEGENDARY,
                Tribe.DRAGON, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }
}
