package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasStealth;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class StranglethornTiger extends Minion {

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

    public StranglethornTiger(Player owner) {

        super(5, 5, 5, "Stranglethorn Tiger", owner,"Stealth", Rarity.COMMON,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new HasStealth(this));
    }

}