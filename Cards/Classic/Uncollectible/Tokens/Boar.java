package Cards.Classic.Uncollectible.Tokens;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 6/27/2017.
 */
public class Boar extends Minion {

    // State
    public int hp = 1;
    public int atk = 1;
    public int cost = 1;
    public String name = "Boar";
    private String text = "";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.GENERAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public Boar(Player owner) {

        super(1, 1, 1, "Boar", owner, "", Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }
}
