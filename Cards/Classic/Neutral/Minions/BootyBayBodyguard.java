package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Booty Bay Bodyguard Minion
 */
public class BootyBayBodyguard extends Minion {

    // State
    public int hp = 4;
    public int atk = 5;
    public int cost = 5;
    public String name = "Booty Bay Bodyguard";
    private String text = "Taunt";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public BootyBayBodyguard() {

        super(4, 5, 5, "Booty Bay Bodyguard", "Taunt", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.TAUNT);
    }


    @Override
    public void onDeath() {

    }

    @Override
    public void onSummon() {

    }

    @Override
    public void onTurnStart() {

    }
}