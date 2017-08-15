package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.HasElusive;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class FaerieDragon extends Minion {

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

    public FaerieDragon(Player owner) {

        super(2, 3, 2, "Faerie Dragon", owner,
                "Can't be targeted by spells or Hero Powers.", Rarity.COMMON,
                Tribe.DRAGON, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new HasElusive(this));
    }
}
