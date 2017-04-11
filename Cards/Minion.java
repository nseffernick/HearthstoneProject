package Cards;

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
    public int hp;
    public int maxHP;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Keywords> properties;

    public Minion(int hp, int atk, int cost, String name,
                  String text, Rarity rarity, Tribe tribe,
                  HeroClass heroClass, ArrayList properties) {

        super(cost, name, text, rarity, heroClass, properties);

        this.atk = atk;
        this.hp = hp;
        this.maxHP = hp;
        this.cost = cost;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.tribe = tribe;

        this.properties = properties;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getAtk() {
        return hp;
    }

    public Tribe getTribe() {
        return tribe;
    }

    public ArrayList<Keywords> getProperties() {
        return properties;
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

    public boolean isDead() {
        return hp <= 0;
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

    public boolean isFrozen() {
        return false;
    }

    public boolean comboActivated() {
        return false;
    }

    public boolean elementalActivated() {
        return false;
    }

    public void onDeath() {

    }

    public void onSummon() {

    }

    public void onTurnStart() {

    }

    public void onHit() {

    }

    public void deathrattle() {

    }

    public void enrage() {

    }

    public void battlecry() {

    }



}




