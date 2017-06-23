package Cards.Classic.Uncollectible.Tokens.HeroPowerTotems;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/27/2017. nxs1720@g.rit.edu
 */
public class StoneclawTotem extends Minion {

    // State
    public int hp = 2;
    public int atk = 0;
    public int cost = 1;
    public String name = "Stoneclaw Totem";
    private String text = "Taunt";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public StoneclawTotem() {

        super(2, 0, 1, "Stoneclaw Totem", "", Rarity.BASIC, Tribe.TOTEM,
                HeroClass.SHAMAN, new ArrayList<Keywords>());
        properties.add(Keywords.TAUNT);
    }
}