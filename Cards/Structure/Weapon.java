package Cards.Structure;

import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

/**
 * Created by Nathan Seffernick on 3/20/2017. nxs1720@g.rit.edu
 */
public abstract class Weapon extends Card {

    // State
    protected int cost;
    protected int durability;
    protected int atk;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;
    protected ArrayList<Keywords> properties;

    public Weapon(int cost, int atk, int durability, String name, String text, Player player,
                  Rarity rarity, HeroClass heroClass, ArrayList properties) {

        super(cost, name, text, player, rarity, heroClass, properties);

        this.cost = cost;
        this.durability = durability;
        this.atk = atk;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.heroClass = heroClass;
        this.properties = properties;
    }

    public int getAtk() {
        return atk;
    }

    public int getDurability() {
        return durability;
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

    public boolean isPlayed() {
        return false;
    }

    public boolean isBroken() {
        return durability <= 0;
    }

    public void addDurability(int set) {
        durability += set;
    }

    public void addAtk(int set) { atk += set; }

}
