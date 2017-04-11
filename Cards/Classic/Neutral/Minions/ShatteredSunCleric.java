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
public class ShatteredSunCleric extends Minion {
    // State
    public int hp = 2;
    public int atk = 3;
    public int cost = 3;
    public String name = "Shattered Sun Cleric";
    private String text = "Battlecry: Give a friendly minion +1/+1.";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public ShatteredSunCleric() {

        super(2, 3, 3, "Shattered Sun Cleric",
                "Battlecry: Give a friendly minion +1/+1", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
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
