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
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;
    protected ArrayList<Keywords> properties;
    protected Player owner;

    public Card(int cost, String name, String text, Player owner,
                Rarity rarity, HeroClass heroClass, ArrayList properties) {

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

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public ArrayList<Keywords> getProperties() {
        return properties;
    }

    public boolean canPlay(int cost, int mana) {
        if (mana >= cost) {
            return true;
        }
        return false;
    }

    public String toString(String name) {
        return name;
    }

}