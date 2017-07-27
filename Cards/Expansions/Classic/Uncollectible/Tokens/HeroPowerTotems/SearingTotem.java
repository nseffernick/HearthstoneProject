package Cards.Expansions.Classic.Uncollectible.Tokens.HeroPowerTotems;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/27/2017. nxs1720@g.rit.edu
 */
public class SearingTotem extends Minion {

    // State
    public int hp = 1;
    public int atk = 1;
    public int cost = 1;
    public String name = "Searing Totem";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public SearingTotem(Player player) {

        super(1, 1, 1, "Searing Totem", player, "", Rarity.BASIC, Tribe.TOTEM,
                HeroClass.SHAMAN, new ArrayList<Keywords>());
    }
}