package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Boulderfist Ogre Minion
 */
public class BoulderfistOgre extends Minion {

    // State
    public int hp = 7;
    public int atk = 6;
    public int cost = 6;
    public String name = "Boulderfist Ogre";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public BoulderfistOgre() {

        super(7, 6, 6, "Boulderfist Ogre", "", Rarity.BASIC,
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