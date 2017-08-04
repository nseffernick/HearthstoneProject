package Cards.Structure;

import Game.Auras.Aura;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

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
    protected boolean enraged;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected String name;
    protected String text;
    protected ArrayList<Keywords> properties;

    public Minion(int hp, int atk, int cost, String name, Player owner,
                  String text, Rarity rarity, Tribe tribe,
                  HeroClass heroClass, ArrayList<Keywords> properties) {

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
        this.enraged = false;
    }

    //Copy constructor
    public Minion(Minion minion) {
        super(minion);
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getAtk() {
        return atk;
    }

    public Tribe getTribe() {
        return tribe;
    }

    // Important that addHp is +=
    public void addHp(int set, BoardState board) {
        hp += set;
        enrageProc();
        if (set < 0) {
            onHit();
            if (isDead()) {
                if (properties.contains(Keywords.AURA)) {
                    for (Aura aura: owner.getAuras()) {
                        if (aura.getLink() == this) {
                            owner.removeAura(aura, board);
                            deathrattle(board);
                            break;
                        }
                    }
                }
                owner.placeCardInGraveyard(this, board);
            }
        }
        if (set > 0) {
            for (Minion minion: owner.getPlayerSide()) {
                minion.healProc();
            }
            if (hp > maxHP) {
                int hpDiff = hp - maxHP;
                hp -= hpDiff;
            }
        }
    }

    public void addMaxHP(int set) {
        maxHP += set;
    }

    public void addAtk(int set) {
        atk += set;
    }

    // Checks various properties that would prevent the minion from attacking.
    public boolean canAttack() {
        System.out.println(properties);
        if (!properties.contains(Keywords.CANTATTACK)) {
            if (atk > 0) {
                if (properties.contains(Keywords.FREEZE)) {
                    System.out.println("Your minion is frozen!");
                    return false;
                }
                if (hasAttacked()) {
                    System.out.println("Your minion has already attacked!");
                    return false;
                }
                if (properties.contains(Keywords.SUMMONSICKNESS)) {
                    if (properties.contains(Keywords.CHARGE)) {
                        return true;
                    }
                    else {
                        System.out.println("Your minion needs a turn to get ready.");
                        return false;
                    }
                }
                return true;
            }
            System.out.println("Your minion must have more than 0 attack.");
            return false;
        }
        System.out.println("Your minion can't attack!");
        return false;
    }

    private boolean hasAttacked() {
        if (properties.contains(Keywords.HASATTACKED)) {
            if (properties.contains(Keywords.WINDFURY)) {
                int atkCount = 0;
                for (Keywords keywords : properties) {
                    if (keywords == Keywords.HASATTACKED) {
                        atkCount += 1;
                    }
                    if (atkCount == 2) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public void destroy(BoardState board) {
        owner.placeCardInGraveyard(this, board);
        deathrattle(board);
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

    public void disableAura() {}

    public void onHit() {}

    public void deathrattle(BoardState board) {}

    public void enrage() {}

    public void battlecry(BoardState board, Player player) { }

    public void endOfTurn(BoardState board) {}

    public void endOfYourTurn(BoardState board) {}

    public void healProc() {}

    public void cardPlayedProc(Card card, BoardState board) {
        if (properties.contains(Keywords.CARDPLAYED)) {

        }
        if (card instanceof Weapon) {
            if (properties.contains(Keywords.WEAPONPLAYED)) {
                Weapon weapon = (Weapon)card;
                weaponPlayedProc(weapon, board);
            }
        }
        else if (card instanceof Minion) {
            if (properties.contains(Keywords.MINIONPLAYED)) {
                Minion minion = (Minion) card;
                minionPlayedProc(minion, board);
            }
        }
        else if (card instanceof Spell) {
            if (properties.contains(Keywords.SPELLCASTED)) {
                Spell spell = (Spell) card;
                spellCastedProc(spell, board);
            }
        }
    }

    public void cardPlayed(BoardState board) {}

    public void minionPlayedProc(Minion minion, BoardState board) {}

    public void weaponPlayedProc(Weapon weapon, BoardState board) {}

    public void spellCastedProc(Spell spell, BoardState board) {}

    public void minionSummonedProc(Minion minion, BoardState board) {}

    public void buffTillEndOfTurn(int set, BoardState board) {
        properties.add(Keywords.TEMPBUFF);

    }

    private void enrageProc() {
        if (properties.contains(Keywords.ENRAGE)) {
            if (enraged && hp < maxHP) ;
            else if (enraged && hp == maxHP) {
                enrage();
                enraged = false;
            }
            else if (!enraged && hp < maxHP) {
                enrage();
                enraged = true;
            }
            else if (!enraged && hp == maxHP) ;
        }
    }

    public static String fixedLengthString(String string, int length) {
        return String.format("%1$"+length+ "s", string);
    }

    //15x43 (optimized for acidic swamp ooze)
    public String toString() {
        String s1 = "____________________________________   \n";
        String s2 = fixedLengthString("| Cost: " + cost + "                            |   \n", 43);
        String s3 = fixedLengthString("| Name:             " + name + "|   \n", 43);
        String s4 = fixedLengthString("|                                    |   \n", 43);
        String s5 = fixedLengthString("|                                    |   \n", 43);
        String s8 = fixedLengthString("|                                    |   \n", 43);
        String s9;
        if (text.equals("")) { s9 = fixedLengthString("|                                    |   \n", 43);}
        else { s9 = fixedLengthString(" | " + text + "|   \n", 43); }
        String s10;
        if (tribe == Tribe.GENERAL) { s10 = fixedLengthString("|                                    |   \n", 43); }
        else { s10 = fixedLengthString("|               " + tribe + "                |   \n", 43); }
        String s11 = fixedLengthString("|                                    |   \n", 43);
        String s12 = fixedLengthString("| Attack: " + atk + "                          |   \n", 43);
        String s13 = fixedLengthString("| Health: " + hp + "                          |   \n", 43);
        String s15 = fixedLengthString("|____________________________________|   \n", 43);
        String cardDesc = s1 + s2 + s3 + s4 + s5 + s8 + s9 + s10 + s11 + s12 + s13 + s15;
        return cardDesc;
    }
        /*
        return  " ____________________________________\n" +
                "| Cost: " + cost + "                      |   \n" +
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
        */

}




