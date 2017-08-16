package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class AngryChicken extends Minion {

    // State
    protected int hp;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Enchantments> enchantments;

    public AngryChicken(Player owner) {

        super(1, 1, 1, "Angry Chicken", owner,"", Rarity.RARE,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new ChickenEnrage(this));
    }

    @Override
    public void enrage() {
        if (enraged) addAtk(-5);
        else addAtk(5);
    }

    public static class ChickenEnrage extends Enchantments {

        public ChickenEnrage(CanHaveEnchantments link) {
            super(Keywords.ENRAGE, "Amani Enrage", link);
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                if (minionLink.isEnraged()) minionLink.addAtk(-5);
                else minionLink.addAtk(5);
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {
        }
    }
}