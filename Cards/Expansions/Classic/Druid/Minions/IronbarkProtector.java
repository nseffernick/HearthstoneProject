package Cards.Expansions.Classic.Druid.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class IronbarkProtector extends Minion {

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


    public IronbarkProtector(Player owner) {

        super(8, 8, 8, "Ironbark Protector", owner,"Taunt", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.DRUID, new ArrayList<Keywords>());
        properties.add(Keywords.TAUNT);
    }

}