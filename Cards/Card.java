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

    public Card(int cost, String name, String text,
                Rarity rarity, HeroClass heroClass, ArrayList properties) {

        this.cost = cost;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.heroClass = heroClass;
        this.properties = properties;
    }

    public int getCost() {
        return cost;
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

    /**
     * Who = 1 will return your player
     * Who = 2 will return the enemy
     * @return
     */
    protected Player findPlayer(int who) {
        if (who == 1) {
            return BoardState.getP1();
        }
        else {
            return BoardState.getP2();
        }
    }

}