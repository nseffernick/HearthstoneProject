package Player;

import Cards.Classic.Uncollectible.Weapons.BloodFury;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

/**
 * ME 3/19/17
 */
public class HeroPower {

    // State
    private int cost;
    private String name;
    private boolean castable;

    public HeroPower(String name) {
        initializeHeroPower(name);
    }

    private void initializeHeroPower(String name) {
        if (name.equals("Life Tap")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Lesser Heal")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Steady Shot")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Fireblast")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Armor Up")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Totemic Call")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Dagger Mastery")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Reinforce")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Shapeshift")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("DIE, INSECT")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("INFERNO!")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
    }

    public void Cast(String name, boolean castable, Player player) {
        if (castable) {
            switch (name) {
                case "Shapeshift": player.hero.atk += 1; player.hero.armor += 1;
                case "Reinforce":;
                case "Dagger Mastery":;
                case "Totemic Call":;
                case "Fireblast":;
                case "Armor Up": player.hero.armor += 2;
                case "Life Tap": player.hero.hp -= 2;
                case "Steady Shot":;
                case "Lesser Heal":;
                case "DIE, INSECT":;
                case "INFERNO!":;
            }
            this.castable = false;
        }
        System.out.println("Cannot cast Hero Power");
    }

}