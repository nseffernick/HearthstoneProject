package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Malygos extends Minion {

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

    public Malygos(Player owner) {

        super(12, 4, 9, "Malygos", owner,"Spell Damage +5", Rarity.LEGENDARY,
                Tribe.DRAGON, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.SPELLDAMAGE);
        properties.add(Keywords.SPELLDAMAGE);
        properties.add(Keywords.SPELLDAMAGE);
        properties.add(Keywords.SPELLDAMAGE);
        properties.add(Keywords.SPELLDAMAGE);
    }
}