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
public class HealingTotem extends Minion {

    // State
    public int hp = 2;
    public int atk = 0;
    public int cost = 1;
    public String name = "Healing Totem";
    private String text = "At the end of your turn restore 1 health" +
            " to all friendly minions";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public HealingTotem() {

        super(2, 0, 1, "Healing Totem", "At the end of your " +
                        "turn restore 1 health to all friendly minions",
                Rarity.BASIC, Tribe.TOTEM, HeroClass.SHAMAN,
                new ArrayList<Keywords>());
        properties.add(Keywords.WHENEVER);
    }
}