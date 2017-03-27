package Player;

import Cards.Weapon;
import Cards.Classic.Uncollectible.Weapons.*;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

/**
 * ME 3/19/17
 */
public abstract class Hero {

    // State
    public int hp;
    public int atk;
    public int armor;
    private String name;
    private String who;
    private HeroPower heroPower;
    private Weapon weapon;

    public Hero(String name) {
        initializeHero(name);
        this.atk = atk + weapon.atk;
    }

    private void initializeHero(String who) {
        if (who.equals("Warlock")) {
            this.hp = 30;
            this.atk = 0;
            this.armor = 0;
            this.heroPower = new HeroPower("Life Tap");
            this.name = "Gul'Dan";
        }
        if (who.equals("Warrior")) {
            this.hp = 30;
            this.atk = 0;
            this.armor = 0;
            this.heroPower = new HeroPower("Armor Up");
            this.name = "Garrosh Hellscream";
        }
        if (who.equals("Hunter")) {
            this.hp = 30;
            this.atk = 0;
            this.armor = 0;
            this.heroPower = new HeroPower("Steady Shot");
            this.name = "Rexxar";
        }
        if (who.equals("Druid")) {
            this.hp = 30;
            this.atk = 0;
            this.armor = 0;
            this.heroPower = new HeroPower("Shapeshift");
            this.name = "Malfurion Stormrage";
        }
        if (who.equals("Priest")) {
            this.hp = 30;
            this.atk = 0;
            this.armor = 0;
            this.heroPower = new HeroPower("Lesser Heal");
            this.name = "Anduin Wrynn";
        }
        if (who.equals("Rogue")) {
            this.hp = 30;
            this.atk = 0;
            this.armor = 0;
            this.heroPower = new HeroPower("Dagger Mastery");
            this.name = "Valeera Sanguinar";
        }
        if (who.equals("Shaman")) {
            this.hp = 30;
            this.atk = 0;
            this.armor = 0;
            this.heroPower = new HeroPower("Totemic Call");
            this.name = "Thrall";
        }
        if (who.equals("Paladin")) {
            this.hp = 30;
            this.atk = 0;
            this.armor = 0;
            this.heroPower = new HeroPower("Reinforce");
            this.name = "Uther Lightbringer";
        }
        if (who.equals("Mage")) {
            this.hp = 30;
            this.atk = 0;
            this.armor = 0;
            this.heroPower = new HeroPower("Fireblast");
            this.name = "Jaina Proudmoore";
        }
        if (who.equals("Ragnaros The Firelord")) {
            this.hp = 8;
            this.atk = 0;
            this.armor = 0;
            this.heroPower = new HeroPower("DIE, INSECT");
            this.name = "Ragnaros The Firelord";
        }
        if (who.equals("Jaraxxus")) {
            this.hp = 15;
            this.atk = 0;
            this.armor = 0;
            this.weapon = new BloodFury(3, 3, 8, "Blood Fury",
                    "", Rarity.BASIC, HeroClass.WARLOCK,
                    new ArrayList<Keywords>());
            this.heroPower = new HeroPower("INFERNO!");
            this.name = "Lord Jaraxxus";
        }
    }
}