package Cards;


import Player.Player;
import Utility.Effects.Property;
import Utility.Rarities.Rarity;
import Utility.HeroClasses.HeroClass;

import java.util.ArrayList;

/**
 * ME 3/19/17
 */
public abstract class Card {

    // State
    private int cost;
    private String name;
    private String text;
    private Rarity rarity;
    private HeroClass heroClass;
    private ArrayList<Property> properties;

    public Card(int cost, String name, String text,
                Rarity rarity, HeroClass heroClass, ArrayList properties) {

        this.cost = cost;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.heroClass = heroClass;

        this.properties = properties;
    }

    public boolean canPlay(int cost, int mana) {
        if (mana >= cost) {
            return true;
        }
        return false;
    }

    public abstract boolean isPlayed();

    public String toString(String name) {
        return name;
    }

    public abstract boolean canTarget(int atk, Player player);

}