package Cards.Classic.Uncollectible.Weapons;

import Cards.Weapon;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/27/2017. nxs1720@g.rit.edu
 */
public class WickedKnife extends Weapon{

    public int cost = 1;
    public int atk = 1;
    public int durability = 2;
    public String name = "Wicked Knife";
    private String text = "";
    private Rarity rarity = Rarity.BASIC;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public WickedKnife(Player player) {
        super(1, 1, 2, "Wicked Knife", "", player, Rarity.BASIC,
                HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }

}
