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
public class FrostwolfGrunt extends Minion {

    // State
    public int hp = 2;
    public int atk = 2;
    public int cost = 2;
    public String name = "Booty Bay Bodyguard";
    private String text = "Taunt";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public FrostwolfGrunt() {

        super(2, 2, 2, "Booty Bay Bodyguard", "Taunt", Rarity.BASIC,
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
