package Cards.Structure;

import Game.Auras.Aura;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Enchantments.Structure.Keywords;

import java.util.ArrayList;

/**
 * ME 3/19/17
 */
public abstract class Minion extends Card implements CanHaveEnchantments {

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
    protected ArrayList<Enchantments> enchantments;

    public Minion(int hp, int atk, int cost, String name, Player owner,
                  String text, Rarity rarity, Tribe tribe,
                  HeroClass heroClass, ArrayList<Enchantments> enchantments) {

        super(cost, name, text, owner, rarity, heroClass);

        this.atk = atk;
        this.hp = hp;
        this.maxHP = hp;
        this.cost = cost;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.tribe = tribe;
        this.heroClass = heroClass;
        this.enchantments = enchantments;
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

    public ArrayList<Enchantments> getEnchantments() { return enchantments; }

    public boolean isEnraged() { return enraged; }

    // Important that addHp is +=
    public void addHp(int set, BoardState board) {
        hp += set;
        enrageProc();
        if (set < 0) {
            onHit();
            if (isDead()) {
                for (Enchantments enchantments: enchantments) {
                    if (enchantments.getKeyword() == Keywords.AURA) {
                        for (Aura aura : owner.getAuras()) {
                            if (aura.getLink() == this) {
                                owner.removeAura(aura, board);
                                deathrattle(board);
                                break;
                            }
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
        boolean shouldMinionLoseHealth = maxHP - hp < -set;
        if (shouldMinionLoseHealth) {
            int healthLost = (maxHP - hp) - set;
            maxHP += set;
            hp += healthLost;
        }
        else if (set > 0) {
            maxHP += set;
            hp += set;
        }
        else {
            maxHP += set;
        }
    }

    public void addAtk(int set) {
        atk += set;
    }

    public void setAtk(int set) { atk = set; }

    public void setMaxHP(int set) { maxHP = set; }

    public void setHp(int set) { hp = set; }

    public void setCost(int set) { cost = set; }

    // Checks various enchantments that would prevent the minion from attacking.
    public boolean canAttack() {
        System.out.println(enchantments);
        if (!checkForKeyword(Keywords.CANTATTACK, enchantments)) {
            if (atk > 0) {
                if (checkForKeyword(Keywords.FREEZE, enchantments)) {
                    System.out.println("Your minion is frozen!");
                    return false;
                }
                if (hasAttacked()) {
                    System.out.println("Your minion has already attacked!");
                    return false;
                }
                if (checkForKeyword(Keywords.SUMMONSICKNESS, enchantments)) {
                    if (checkForKeyword(Keywords.CHARGE, enchantments)) {
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
        if (checkForKeyword(Keywords.HASATTACKED, enchantments)) {
            if (checkForKeyword(Keywords.WINDFURY, enchantments)) {
                int atkCount = 0;
                for (Enchantments enchantments : enchantments) {
                    if (enchantments.getKeyword() == Keywords.HASATTACKED) {
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

    //TODO some way of canceling most battlecries, prolly make this a boolean method
    public void battlecry(BoardState board, Player player, int position) { }

    public void startOfYourTurn(BoardState board) {}

    public void startOfTurn(BoardState board) {}

    public void endOfTurn(BoardState board) {}

    public void endOfYourTurn(BoardState board) {}

    public void healProc() {}

    public void cardPlayedProc(Card card, BoardState board) {
        if (checkForKeyword(Keywords.CARDPLAYED, enchantments)) {
            if (checkForKeyword(Keywords.CARDPLAYED, enchantments)) {
                cardPlayedProc(card, board);
            }
        }
        if (card instanceof Weapon) {
            if (checkForKeyword(Keywords.WEAPONPLAYED, enchantments)) {
                Weapon weapon = (Weapon)card;
                weaponPlayedProc(weapon, board);
            }
        }
        else if (card instanceof Minion) {
            if (checkForKeyword(Keywords.MINIONPLAYED, enchantments)) {
                Minion minion = (Minion) card;
                minionPlayedProc(minion, board);
            }
        }
        else if (card instanceof Spell) {
            if (checkForKeyword(Keywords.SPELLCASTED, enchantments)) {
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

    public void weaponState() {}

    public void minionDeath(Minion minion) {}

    private void enrageProc() {
        if (checkForKeyword(Keywords.ENRAGE, enchantments)) {
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
        int newCost = cost;
        if (cost < 0) {
            newCost = 0;
        }
        String s1 = "____________________________________   \n";
        String s2 = fixedLengthString("| Cost: " + newCost + "                            |   \n", 43);
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




