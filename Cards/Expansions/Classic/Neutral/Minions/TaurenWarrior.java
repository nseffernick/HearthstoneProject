package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class TaurenWarrior extends Minion {

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

    public TaurenWarrior(Player owner) {

        super(3, 2, 3, "Tauren Warrior", owner, "Taunt Enrage: +3 Attack",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.ENRAGE);
        properties.add(Keywords.TAUNT);
    }

    @Override
    public void enrage() {
        if (enraged) addAtk(-3);
        else addAtk(3);
    }
}