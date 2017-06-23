package Cards;

import Utility.Effects.Property;
import Utility.Rarities.Rarity;
import Utility.HeroClasses.HeroClass;
import Game.Player.Player;

import java.util.ArrayList;

/**
 *
 */
public abstract class Spell extends Card {

    // State
    private int cost;
    private String name;
    private String text;
    private Rarity rarity;
    private HeroClass heroClass;
    private ArrayList<Property> properties;

    public Spell(int cost, String name, String text, Rarity rarity,
                 HeroClass heroClass, ArrayList<Property> properties) {
        super(cost, name, text, rarity, heroClass, properties);


        this.cost = cost;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.heroClass = heroClass;

        this.properties = properties;
    }

    public boolean canTarget(int atk, Card aCard, Player aPlayer) {
        return true;
    }

    public boolean canPlay(int cost, int mana) {
        return true;
    }

    @Override
    public boolean isPlayed() {
        return false;
    }

}




