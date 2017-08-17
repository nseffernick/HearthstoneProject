package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasWindfury;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class YoungDragonhawk extends Minion {

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

    public YoungDragonhawk(Player owner) {

        super(1, 1, 1, "Young Dragonhawk", owner,"Windfury", Rarity.COMMON,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new HasWindfury(this));
    }

}
