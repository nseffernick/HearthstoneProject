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
public class WolfRider extends Minion {
    // State
    public int hp = 1;
    public int atk = 3;
    public int cost = 3;
    public String name = "Wolf Rider";
    private String text = "Charge";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public WolfRider() {

        super(1, 3, 3, "Wolf Rider", "Charge", Rarity.BASIC,
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
