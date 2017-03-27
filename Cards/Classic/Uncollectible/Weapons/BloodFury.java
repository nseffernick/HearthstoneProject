package Cards.Classic.Uncollectible.Weapons;

import Cards.Weapon;
import Utility.Effects.Property;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/26/2017.
 */
public class BloodFury extends Weapon {

    public int cost = 3;
    public int durability = 8;
    public int atk = 3;
    public String name = "Blood Fury";
    private String text = null;
    private Rarity rarity = Rarity.BASIC;
    private HeroClass heroClass = HeroClass.WARLOCK;
    private ArrayList<Keywords> properties;

    public BloodFury(int cost, int atk, int durability, String name,
                     String text, Rarity rarity,
                     HeroClass heroClass, ArrayList<Keywords> properties) {

        super(cost, atk, durability, name, text, rarity, heroClass, properties);

        this.cost = cost;
        this.durability = durability;
        this.atk = atk;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.heroClass = heroClass;

        properties = new ArrayList();
    }
}
