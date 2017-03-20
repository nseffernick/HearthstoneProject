package Cards;


import Uility.Effects.Property;

import java.util.ArrayList;

/**
 * ME 3/19/17
 */
public abstract class Card {

    // State
    private int cost;
    private String name;
    private String text;
    private String rarity;
    private String heroClass;
    private ArrayList<Property> properties;

    public Card(int cost, String name, String text,
                String rarity, ArrayList properties) {

        this.cost = cost;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.heroClass = heroClass;

        this.properties = properties;
    }

    public boolean canPlay(int cost, int mana) {
        return false;
    }

    public String toString(String name) {
        return name;
    }


}