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
public class WrathOfAir extends Minion {

    // State
    public int hp = 2;
    public int atk = 0;
    public int cost = 1;
    public String name = "Wrath of Air Totem";
    private String text = "Spell Damage +1";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public WrathOfAir(Player player) {

        super(2, 0, 1, "Wrath of Air Totem", player, "", Rarity.BASIC,
                Tribe.TOTEM, HeroClass.SHAMAN, new ArrayList<Keywords>());
        properties.add(Keywords.SPELLDAMAGE);
    }
}