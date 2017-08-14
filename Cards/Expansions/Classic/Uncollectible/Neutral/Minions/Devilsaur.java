package Cards.Expansions.Classic.Uncollectible.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Devilsaur extends Minion {

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

    public Devilsaur(Player owner) {

        super(5, 5, 5, "Devilsaur", owner, "", Rarity.COMMON,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }
}
