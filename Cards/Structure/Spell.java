package Cards.Structure;

import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.HeroClasses.HeroClass;
import Game.Player.Player;

import java.util.ArrayList;

/**
 *
 */
public abstract class Spell extends Card {

    // State
    protected int cost;
    protected Rarity rarity;
    protected HeroClass heroClass;
    protected String name;
    protected String text;
    protected Player owner;
    protected ArrayList<Keywords> properties;

    public Spell(int cost, String name, String text, Player owner, Rarity rarity,
                 HeroClass heroClass, ArrayList<Keywords> properties) {
        super(cost, name, text, owner, rarity, heroClass, properties);

        this.cost = cost;
        this.name = name;
        this.text = text;
        this.owner = owner;
        this.rarity = rarity;
        this.heroClass = heroClass;
        this.properties = properties;
    }

    public Spell(Spell spell) {
        super(spell);
    }

    public boolean canPlay(int cost, int mana) {
        return mana <= cost;
    }

}




