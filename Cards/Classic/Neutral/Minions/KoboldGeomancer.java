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
public class KoboldGeomancer extends Minion{
    // State
    public int hp = 2;
    public int atk = 2;
    public int cost = 2;
    public String name = "Kobold Geomancer";
    private String text = "Spell Damage +1";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public KoboldGeomancer() {

        super(2, 2, 2, "Kobold Geomancer", "Spell Damage +1", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.SPELLDAMAGE);
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
