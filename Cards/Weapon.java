package Cards;

import Game.Player.Player;
import Utility.Effects.Property;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

/**
 * Created by Nathan Seffernick on 3/20/2017. nxs1720@g.rit.edu
 */
public abstract class Weapon extends Card {

    // State
    public int cost;
    public int durability;
    public int atk;
    public String name;
    private String text;
    private Rarity rarity;
    private HeroClass heroClass;
    private ArrayList<Property> properties;

    public Weapon(int cost, int atk, int durability, String name, String text,
                  Rarity rarity, HeroClass heroClass, ArrayList properties) {

        super(cost, name, text, rarity, heroClass, properties);

        this.cost = cost;
        this.durability = durability;
        this.atk = atk;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.heroClass = heroClass;

        this.properties = properties;
    }

    public boolean canTarget(int atk, Player player) {
        return false;
    }

    public boolean canPlay(int cost, int mana) {
        return false;
    }

    public String toString(String name) {
        return name;
    }

    @Override
    public boolean isPlayed() {
        return false;
    }


}
