package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class SpitefulSmith extends Minion {

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

    public SpitefulSmith(Player owner) {

        super(6, 4, 5, "Spiteful Smith", owner, "Enrage: your weapon gains +2 attack",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.ENRAGE);
        boolean enraged = false;
    }

    @Override
    public void enrage() {
        if (enraged) owner.getHero().getWeapon().addAtk(-2);
        else owner.getHero().getWeapon().addAtk(2);
    }
}