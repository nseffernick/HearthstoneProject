package Cards.Structure;


import Game.Player.Player;
import Game.BoardState;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.HeroClasses.HeroClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * ME 3/19/17
 */
public abstract class Card {

    // State
    protected int cost;
    protected Rarity rarity;
    protected HeroClass heroClass;
    protected String name;
    protected String text;
    protected Player owner;
    protected ArrayList<Enchantments> enchantments;

    public Card(int cost, String name, String text, Player owner,
                Rarity rarity, HeroClass heroClass, ArrayList<Enchantments> enchantments) {

        this.cost = cost;
        this.name = name;
        this.text = text;
        this.rarity = rarity;
        this.heroClass = heroClass;
        this.enchantments = enchantments;
        this.owner = owner;
    }

    // Copy constructor
    public Card(Card copyCard) {
        this.cost = copyCard.cost;
        this.rarity = copyCard.rarity;
        this.name = copyCard.name;
        this.text = copyCard.text;
        this.heroClass = copyCard.heroClass;
        this.enchantments = new ArrayList<>();
        enchantments.addAll(copyCard.enchantments);
        this.owner = copyCard.owner;
    }

    public int getCost() { return cost; }

    public Rarity getRarity() { return rarity; }

    public HeroClass getHeroClass() { return heroClass; }

    public String getName() { return name; }

    public String getText() { return text; }

    public ArrayList<Enchantments> getEnchantments() { return enchantments; }

    public Player getOwner() { return owner; }

    public boolean canPlay(BoardState board) { return owner.getMana() >= cost; }

    public String toString(String name) { return name; }

    public void updateCostFromHeroHP() {};

    public void updateCostFromHandSize() {};

    public void updateCostFromBoardSize(BoardState board) {};

    public void addCost(int set) { cost += set; }

    public void setOwner(Player player) { owner = player; }

    protected void returnBackToHand(int index, Player target) {
        Minion minion = target.getPlayerSide().get(index);
        target.getPlayerSide().remove(minion);
        Class newMinion = minion.getClass();
        try {
            Constructor constructor = newMinion.getConstructor(Player.class);
            Object card1 = constructor.newInstance(target);
            if (card1 instanceof Minion) {
                Minion minion1 = (Minion) card1;
                target.getHand().add(minion1);
            }
        }
        catch (InstantiationException | InvocationTargetException | IllegalAccessException |  NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    protected void damageAllCharacters(BoardState board, int dmg) {
        Damaging.damageCharacter(board.getP1(), -1, -dmg, board);
        Damaging.damageCharacter(board.getP2(), -1, -dmg, board);
        for (int i = 0; i < board.getP1().getPlayerSide().size(); i++) {
            Damaging.damageCharacter(board.getP1(), i, dmg, board);
        }
        for (int x = 0; x < board.getP2().getPlayerSide().size(); x++) {
            Damaging.damageCharacter(board.getP2(), x, dmg, board);
        }
    }

    protected void chooseOne() {}

}