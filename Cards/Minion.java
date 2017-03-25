package Cards;

import Utility.Effects.Property;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import Player.Player;

import java.util.ArrayList;



/**
 * ME 3/19/17
 */
public abstract class Minion extends Card {

    // State
    private int hp;
    private int atk;
    private int cost;
    private String name;
    private String text;
    private Rarity rarity;
    private Tribe tribe;
    private HeroClass heroClass;
    private ArrayList<Property> properties;

    public Minion(int hp, int atk, int cost, String name,
                  String text, Rarity rarity, Tribe tribe,
                  HeroClass heroClass, ArrayList properties) {

        super(cost, name, text, rarity, heroClass, properties);

        this.atk = atk;
        this.hp = hp;
        this.cost = cost;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.tribe = tribe;

        this.properties = properties;
    }

    public boolean canTarget(int atk, Player player) {
        return true;
    }

    public boolean canAttack(int atk, Player player,
                             int turnsPast, int timesAttacked) {
        if (!(summonSickness(turnsPast))) {
            if (!(hasAttacked(timesAttacked))) {
                return true;
            }
        }
        return false;
    }

    public boolean summonSickness(int turnsPast) {
        return true;
    }

    public boolean hasAttacked(int timesAttacked) {
        if (timesAttacked >= 1) {
            if (properties.contains(Keywords.WINDFURY)) {
                if (timesAttacked == 2) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean isDead(int hp) {
        return false;
    }

    @Override
    public boolean isPlayed() {
        return false;
    }

    public boolean onBoard() {
        return false;
    }

    public boolean inHand() {
        return true;
    }
}




