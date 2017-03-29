package Cards.Classic.Uncollectible.Tokens;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/27/2017. nxs1720@g.rit.edu
 */
public class Infernal extends Minion {

    // State
    public int hp = 6;
    public int atk = 6;
    public int cost = 6;
    public String name = "Infernal";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public Infernal() {

        super(6, 6, 6, "Infernal", "", Rarity.BASIC,
                Tribe.DEMON, HeroClass.WARLOCK, new ArrayList<Keywords>());
    }
}
