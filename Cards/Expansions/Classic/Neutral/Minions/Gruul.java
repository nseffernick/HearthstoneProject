package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Gruul extends Minion {

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

    public Gruul(Player owner) {

        super(7, 7, 8, "Gruul", owner,"At the end of each turn, gain +1/+1 .", Rarity.LEGENDARY,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new GruulBuff(this));
    }

    public static class GruulBuff extends Enchantments {

        // State
        private int turnspast;

        public GruulBuff(CanHaveEnchantments link) {
            super(Keywords.ENDOFTURN, "Gained +1/+1 end of every turn", link);
            turnspast = 0;
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                attackHealthBuff(minionLink, 1);
                turnspast += 1;
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                attackHealthBuff(minionLink, -turnspast);
            }
        }
    }
}