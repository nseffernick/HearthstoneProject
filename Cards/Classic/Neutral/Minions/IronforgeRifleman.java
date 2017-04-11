package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class IronforgeRifleman extends Minion {
    // State
    public int hp = 2;
    public int atk = 2;
    public int cost = 3;
    public String name = "Ironforge Rifleman";
    private String text = "Battlecry: Deal one damage";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public IronforgeRifleman() {

        super(2, 2, 3, "Ironforge Rifleman",
                "Battlecry: Deal one damage", Rarity.BASIC,
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
