package Cards;


import Game.Player.Player;
import Game.BoardState;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.HeroClasses.HeroClass;

import java.util.ArrayList;

/**
 * ME 3/19/17
 */
public abstract class Card {

    // State
    protected int cost;
    protected Rarity rarity;
    protected HeroClass heroClass;
    protected String name;
    protected String text;
    protected Player owner;
    protected ArrayList<Keywords> properties;

    public Card(int cost, String name, String text, Player owner,
                Rarity rarity, HeroClass heroClass, ArrayList<Keywords> properties) {

        this.cost = cost;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.heroClass = heroClass;
        this.properties = properties;
        this.owner = owner;
    }

    public int getCost() {
        return cost;
    }

    public void addCost(int set) {
        cost += set;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public ArrayList<Keywords> getProperties() {
        return properties;
    }

    public boolean canPlay(int cost, int mana) {
        return mana >= cost;
    }

    public String toString(String name) {
        return name;
    }



}