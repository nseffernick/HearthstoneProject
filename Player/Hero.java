package Player;

import Cards.Weapon;
import Cards.Classic.Uncollectible.Weapons.*;
import Player.HeroPowers.*;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * ME 3/19/17
 */
public class Hero {

    // State
    public int hp;
    public int maxHP;
    public int atk;
    public int armor;
    public int spellDamage;
    public HeroClass heroClass;
    private String name;
    private String who;
    private HeroPower heroPower;
    public Weapon weapon;
    public ArrayList<Keywords> properties;

    public Hero(String name) {
        initializeHero(name);
        this.properties = new ArrayList<>();
        this.atk = atk + weapon.atk;
    }

    public HeroPower getHeroPower() {
        return heroPower;
    }

    /**
     * Initializes hero to take the value of one of the classes
     * @param who - the hero class
     */
    private void initializeHero(String who) {
        if (who.equals("Warlock")) {
            this.hp = 30;
            this.maxHP = 30;
            this.atk = 0;
            this.armor = 0;
            this.spellDamage = 0;
            this.heroClass = HeroClass.WARLOCK;
            this.heroPower = new LifeTap();
            this.name = "Gul'Dan";
        }
        if (who.equals("Warrior")) {
            this.hp = 30;
            this.maxHP = 30;
            this.atk = 0;
            this.armor = 0;
            this.spellDamage = 0;
            this.heroPower = new ArmorUp();
            this.name = "Garrosh Hellscream";
        }
        if (who.equals("Hunter")) {
            this.hp = 30;
            this.maxHP = 30;
            this.atk = 0;
            this.armor = 0;
            this.spellDamage = 0;
            this.heroPower = new SteadyShot();
            this.name = "Rexxar";
        }
        if (who.equals("Druid")) {
            this.hp = 30;
            this.maxHP = 30;
            this.atk = 0;
            this.armor = 0;
            this.spellDamage = 0;
            this.heroPower = new Shapeshift();
            this.name = "Malfurion Stormrage";
        }
        if (who.equals("Priest")) {
            this.hp = 30;
            this.maxHP = 30;
            this.atk = 0;
            this.armor = 0;
            this.spellDamage = 0;
            this.heroPower = new LesserHeal();
            this.name = "Anduin Wrynn";
        }
        if (who.equals("Rogue")) {
            this.hp = 30;
            this.maxHP = 30;
            this.atk = 0;
            this.armor = 0;
            this.spellDamage = 0;
            this.heroPower = new DaggerMastery();
            this.name = "Valeera Sanguinar";
        }
        if (who.equals("Shaman")) {
            this.hp = 30;
            this.maxHP = 30;
            this.atk = 0;
            this.armor = 0;
            this.spellDamage = 0;
            this.heroPower = new TotemicCall();
            this.name = "Thrall";
        }
        if (who.equals("Paladin")) {
            this.hp = 30;
            this.maxHP = 30;
            this.atk = 0;
            this.armor = 0;
            this.spellDamage = 0;
            this.heroPower = new Reinforce();
            this.name = "Uther Lightbringer";
        }
        if (who.equals("Mage")) {
            this.hp = 30;
            this.maxHP = 30;
            this.atk = 0;
            this.armor = 0;
            this.spellDamage = 0;
            this.heroPower = new Fireblast();
            this.name = "Jaina Proudmoore";
        }
        if (who.equals("Ragnaros The Firelord")) {
            this.hp = 8;
            this.maxHP = 8;
            this.atk = 0;
            this.armor = 0;
            this.spellDamage = 0;
            this.heroPower = new DieInsect();
            this.name = "Ragnaros The Firelord";
        }
        if (who.equals("Jaraxxus")) {
            this.hp = 15;
            this.maxHP = 15;
            this.atk = 0;
            this.armor = 0;
            this.spellDamage = 0;
            this.weapon = new BloodFury();
            this.heroPower = new Inferno();
            this.name = "Lord Jaraxxus";
        }
    }

    /**
     *
     * @param target
     * @param index
     */
    public void heroAttack(Player target, int index) {
        if (atk > 0) {
            if (index < 0) {
                target.getHero().hp -= atk;
            }
            else {
                target.getPlayerSide().get(index).hp -= atk;
                if (properties.contains(Keywords.IMMUNE));
                else {
                    hp -= target.getPlayerSide().get(index).getAtk();
                }
            }
        }
        else {
            System.out.println("You're hero has no attack!");
        }
    }

    public boolean isDead() {
        return hp <= 0;
    }

    /**
     *
     * @param bm
     */
    public void emote(String bm) {

    }

    public String toString() {
        return name;
    }
}