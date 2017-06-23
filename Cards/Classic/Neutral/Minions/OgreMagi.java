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
public class OgreMagi extends Minion {
    // State
    public int hp = 4;
    public int atk = 4;
    public int cost = 4;
    public String name = "Ogre Magi";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public OgreMagi() {

        super(4, 4, 4, "Ogre Magi", "", Rarity.BASIC,
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