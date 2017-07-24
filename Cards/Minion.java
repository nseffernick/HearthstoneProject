package Cards;

import Game.BoardState;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import Game.Player.Player;

import java.util.ArrayList;

/**
 * ME 3/19/17
 */
public abstract class Minion extends Card {

    // State
    protected int hp;
    protected int maxHP;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Keywords> properties;

    public Minion(int hp, int atk, int cost, String name, Player owner,
                  String text, Rarity rarity, Tribe tribe,
                  HeroClass heroClass, ArrayList properties) {

        super(cost, name, text, owner, rarity, heroClass, properties);

        this.atk = atk;
        this.hp = hp;
        this.maxHP = hp;
        this.cost = cost;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.tribe = tribe;
        this.heroClass = heroClass;
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

    // Important that addHp is +=
    public void addHp(int set) {
        hp += set;
        if (hp > maxHP) {
            hp = maxHP;
        }
    }

    public void addMaxHP(int set) {
        maxHP += set;
    }

    public void addAtk(int set) {
        atk += set;
    }

    // Checks various properties that would prevent the minion from attacking.
    private boolean canAttack(int turnsPast, int timesAttacked) {
        if (properties.contains(Keywords.CANTATTACK)) {
            if (atk > 0) {
                if (properties.contains(Keywords.FREEZE)) {
                    System.out.println("Your minion is frozen!");
                    return false;
                }
                if (hasAttacked(timesAttacked)) {
                    System.out.println("Your minion has already attacked!");
                    return false;
                }
                if (!summonSickness(turnsPast)) {
                    if (properties.contains(Keywords.CHARGE)) {
                        return true;
                    }
                    else {
                        System.out.println("Your minion needs a turn to get ready.");
                        return false;
                    }
                }
            }
            System.out.println("Your minion must have more than 0 attack.");
            return false;
        }
        System.out.println("Your minion can't attack!");
        return false;
    }

    private boolean summonSickness(int turnsPast) {
        return (turnsPast > 0);
    }

    private boolean hasAttacked(int timesAttacked) {
        if (timesAttacked >= 1) {
            if (properties.contains(Keywords.WINDFURY)) {
                if (timesAttacked == 2) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public boolean comboActivated() {
        return false;
    }

    public boolean elementalActivated() {
        return false;
    }

    public void createAura(BoardState board) {}

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

    public void battlecry(BoardState board, Player player, int index) {

    }

    //14x37
    public String toString() {
        return  " ____________________________________\n" +
                "| Cost: " + cost + "                         |\n" +
                "| Name:    " + name + "                        |\n" +
                "|                                    |\n" +
                "|                                    |\n" +
                "|                                    |\n" +
                "|                                    |\n" +
                "| " + text + "                                    |\n" +
                "| " + tribe + "                                |\n" +
                "|                                    |\n" +
                "| Attack: " + atk + "                                    |\n" +
                "| Health: " + hp + "                                  |\n" +
                "|                                    |\n" +
                "|____________________________________|\n";

    }


}




