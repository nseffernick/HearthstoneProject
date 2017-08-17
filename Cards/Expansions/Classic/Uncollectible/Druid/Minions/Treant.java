package Cards.Expansions.Classic.Uncollectible.Druid.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Treant extends Minion {

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

    public Treant(Player owner) {

        super(2, 2, 2, "Treant", owner, "", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.DRUID, new ArrayList<Enchantments>());
    }
}
