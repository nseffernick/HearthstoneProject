package Cards.Expansions.Classic.Uncollectible.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Squire extends Minion {

    // State
    protected int hp;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Enchantments> enchantments;

    public Squire(Player owner) {

        super(2, 2, 1, "Squire", owner, "", Rarity.COMMON,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }
}
