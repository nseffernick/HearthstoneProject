package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the River Crocolisk Minion
 */
public class RiverCroc extends Minion {

    // State
    public int hp = 3;
    public int atk = 2;
    public int cost = 2;
    public String name = "River Crocolisk";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public RiverCroc() {

        super(3, 2, 2, "River Crocolisk", "", Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }


}