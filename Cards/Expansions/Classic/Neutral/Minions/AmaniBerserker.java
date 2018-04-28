package Cards.Expansions.Classic.Neutral.Minions;

import Game.CanHaveEnchantments;
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

public class AmaniBerserker extends Minion {

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

    public AmaniBerserker(Player owner) {

        super(3, 2, 2, "Amani Berserker", owner, "Enrage: +3 Attack",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new AmaniEnrage());
        boolean enraged = false;
    }

    public static class AmaniEnrage extends Enchantments {

        public AmaniEnrage(CanHaveEnchantments link) {
            super(Keywords.ENRAGE, "Amani Enrage", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                if (minionLink.isEnraged()) minionLink.addAtk(-3);
                else minionLink.addAtk(3);
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {
        }
    }
}