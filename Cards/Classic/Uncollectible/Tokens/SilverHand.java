package Cards.Classic.Uncollectible.Tokens;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/27/2017. nxs1720@g.rit.edu
 */
public class SilverHand extends Minion {

    // State
    public int hp = 1;
    public int atk = 1;
    public int cost = 1;
    public String name = "Silver Hand Recruit";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public SilverHand(Player owner) {

        super(1, 1, 1, "Silver Hand Recruit", owner, "", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.PALADIN, new ArrayList<Keywords>());
    }
}
