package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/11/2017.
 */
public class RecklessRocketeer extends Minion {
    // State
    public int hp = 2;
    public int atk = 5;
    public int cost = 6;
    public String name = "Reckless Rocketeer";
    private String text = "Charge";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public RecklessRocketeer() {

        super(2, 5, 6, "Reckless Rocketeer", "Charge", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.CHARGE);
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
