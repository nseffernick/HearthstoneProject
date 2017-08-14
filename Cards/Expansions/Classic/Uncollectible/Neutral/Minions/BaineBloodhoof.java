package Cards.Expansions.Classic.Uncollectible.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class BaineBloodhoof extends Minion {

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

    public BaineBloodhoof(Player owner) {

        super(5, 4, 4, "Baine Bloodhoof", owner, "",
                Rarity.LEGENDARY, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }
}
