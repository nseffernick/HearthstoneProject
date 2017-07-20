package Cards.Classic.Uncollectible.Tokens;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 6/26/2017.
 */
public class MechanicalDragonling extends Minion {

    // State
    public int hp = 1;
    public int atk = 1;
    public int cost = 1;
    public String name = "Mechanical Dragonling";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public MechanicalDragonling() {

        super(1, 1, 1, "Mechanical Dragonling", "", Rarity.BASIC,
                Tribe.MECH, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }
}
