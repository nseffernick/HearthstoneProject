package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class AcolyteOfPain extends Minion {

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

    public AcolyteOfPain(Player owner) {

        super(3, 1, 3, "Acolyte of Pain", owner,
                "Whenever this minion takes damage, draw a card", Rarity.COMMON,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.ONHIT);
    }

    @Override
    public void onHit() {
        if (properties.contains(Keywords.ONHIT)) {
            owner.drawCard();
        }
    }
}