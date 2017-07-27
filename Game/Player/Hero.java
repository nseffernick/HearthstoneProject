package Game.Player;

import Cards.Structure.Weapon;
import Cards.Expansions.Classic.Uncollectible.Weapons.*;
import Game.BoardState;
import Game.Player.HeroPowers.*;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * ME 3/19/17
 * Represents the hero which contains the attributes associated with the
 * physical hero, their atk, hp, class, name, heropower and so on.
 * Player contains attributes that are not specifically part of the hero,
 * so the cards (spelldamage because the hero plays the cards affected by
 * spelldamage, spelldamage is not a part of him), and other more or less
 * automatic attributes like fatigue.
 */
public class Hero {

    // State
    private Weapon weapon;
    private ArrayList<Keywords> properties;
    private int hp;
    private int armor;
    private int maxHP;
    private int atk;
    private HeroClass heroClass;
    private String name;

    public Hero(String name, Player player) {
        initializeHero(name, player);
        this.properties = new ArrayList<>();
    }

    /**
     * Initializes hero to take the value of one of the classes
     * @param who - the hero class
     */
    private void initializeHero(String who, Player player) {
        this.hp = 30;
        this.maxHP = 30;
        this.atk = 0;
        this.armor = 0;
        if (who.equals("Warlock")) {
            this.heroClass = HeroClass.WARLOCK;
            HeroPower heroPower = new LifeTap();
            player.setHeroPower(heroPower);
            this.name = "Gul'Dan";
        }
        else if (who.equals("Warrior")) {
            this.heroClass = HeroClass.WARRIOR;
            HeroPower heroPower = new ArmorUp();
            player.setHeroPower(heroPower);
            this.name = "Garrosh Hellscream";
        }
        else if (who.equals("Hunter")) {
            this.heroClass = HeroClass.HUNTER;
            HeroPower heroPower = new SteadyShot();
            player.setHeroPower(heroPower);
            this.name = "Rexxar";
        }
        else if (who.equals("Druid")) {
            this.heroClass = HeroClass.DRUID;
            HeroPower heroPower = new Shapeshift();
            player.setHeroPower(heroPower);
            this.name = "Malfurion Stormrage";
        }
        else if (who.equals("Priest")) {
            this.heroClass = HeroClass.PRIEST;
            HeroPower heroPower = new LesserHeal();
            player.setHeroPower(heroPower);
            this.name = "Anduin Wrynn";
        }
        else if (who.equals("Rogue")) {
            this.heroClass = HeroClass.ROGUE;
            HeroPower heroPower = new DaggerMastery();
            player.setHeroPower(heroPower);
            this.name = "Valeera Sanguinar";
        }
        else if (who.equals("Shaman")) {
            this.heroClass = HeroClass.SHAMAN;
            HeroPower heroPower = new TotemicCall();
            player.setHeroPower(heroPower);
            this.name = "Thrall";
        }
        else if (who.equals("Paladin")) {
            this.heroClass = HeroClass.PALADIN;
            HeroPower heroPower = new Reinforce();
            player.setHeroPower(heroPower);
            this.name = "Uther Lightbringer";
        }
        else if (who.equals("Mage")) {
            this.heroClass = HeroClass.MAGE;
            HeroPower heroPower = new Fireblast();
            player.setHeroPower(heroPower);
            this.name = "Jaina Proudmoore";
        }
        else if (who.equals("Ragnaros The Firelord")) {
            this.hp = 8;
            this.maxHP = 8;
            this.atk = 0;
            this.armor = 0;
            this.heroClass = HeroClass.NEUTRAL;
            HeroPower heroPower = new DieInsect();
            player.setHeroPower(heroPower);
            this.name = "Ragnaros The Firelord";
        }
        else if (who.equals("Lord Jaraxxus")) {
            this.hp = 15;
            this.maxHP = 15;
            this.atk = 0;
            this.armor = 0;
            this.heroClass = HeroClass.NEUTRAL;
            this.weapon = new BloodFury(player);
            HeroPower heroPower = new Inferno();
            player.setHeroPower(heroPower);
            this.name = "Lord Jaraxxus";
        }
        else {
            System.err.println("You are trying to play as a class that doesn't exist!");
        }
    }

    /**
     * The hero swings itself at another minion or hero.
     * @param target
     * @param index
     */
    public void heroAttack(Player target, int index, BoardState board) {
        if (atk > 0) {
            if (index < 0) {
                target.getHero().hp -= atk;
            }
            else {
                target.getPlayerSide().get(index).addHp(-atk, board);
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

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public ArrayList<Keywords> getProperties() {
        return properties;
    }

    public int getHp(){
        return hp;
    }

    public int getArmor() {
        return armor;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getAtk() {
        return atk;
    }

    public String getName() {
        return name;
    }

    public void addArmor(int set) {
        armor += set;
    }

    public void addHp(int set) {
        hp += set;
    }

    public void setWeapon(Weapon set) {
        weapon = set;
    }

    public void addAtk(int set) {
        atk += set;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    /**
     * Now with custom bm!
     * @param bm
     */
    public void emote(String bm) {

    }

    /**
     * Maybe should be more descriptive in the future for testing
     * @return
     */
    public String toString() {
        return name;
    }
}