package Cards;

import Uility.Effects.Property;

import java.util.ArrayList;

/**
 *
 */
public abstract class Spell extends Card {

    // State
    private int cost;
    private String name;
    private String text;
    private String rarity;
    private ArrayList<Property> properties;

    public Spell(int cost, String name, String text,
                String rarity, ArrayList<Property> properties) {
        super();


        this.cost = cost;
        this.name = name;
        this.text = text;
        this.rarity = rarity;

        this.properties = properties;
    }

    public boolean canTarget(int atk, Card aCard, Player aPlayer) {

    }

    public boolean canPlay(int cost, int mana) {

    }




