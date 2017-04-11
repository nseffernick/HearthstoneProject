package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Core Hound Minion
 */
public class CoreHound extends Minion {

    // State
    public int hp = 5;
    public int atk = 9;
    public int cost = 7;
    public String name = "Core Hound";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public CoreHound() {

        super(5, 9, 7, "Core Hound", "", Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
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