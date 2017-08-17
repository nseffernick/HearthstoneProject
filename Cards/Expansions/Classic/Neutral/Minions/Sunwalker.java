package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasDivineShield;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Sunwalker extends Minion {

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

    public Sunwalker(Player owner) {

        super(5, 4, 6, "Sunwalker", owner,"Taunt Divine Shield", Rarity.RARE,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new HasTaunt(this));
        enchantments.add(new HasDivineShield(this));
    }

}
