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
public class WarGolem extends Minion {
    // State
    public int hp = 7;
    public int atk = 7;
    public int cost = 7;
    public String name = "War Golem";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public WarGolem() {

        super(7, 7, 7, "War Golem", "", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
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