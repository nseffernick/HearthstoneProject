package Cards.Expansions.Classic.Uncollectible.Spells;

import Cards.Structure.Spell;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

public class Banana extends Spell {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;
    protected ArrayList<Keywords> properties;

    public Banana(Player owner) {

        super(1, "Banana", "Give a minion +1/+1", owner,
                Rarity.BASIC, HeroClass.NEUTRAL, new ArrayList<>());
    }
}