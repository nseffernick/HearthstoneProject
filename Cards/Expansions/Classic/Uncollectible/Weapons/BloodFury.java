package Cards.Expansions.Classic.Uncollectible.Weapons;

import Cards.Structure.Weapon;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/26/2017.
 */
public class BloodFury extends Weapon {

    public int cost = 3;
    public int atk = 3;
    public int durability = 8;
    public String name = "Blood Fury";
    private String text = "";
    private Rarity rarity = Rarity.BASIC;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public BloodFury(Player player) {
        super(3, 3, 8, "Blood Fury", "", player, Rarity.BASIC,
                HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }
}
