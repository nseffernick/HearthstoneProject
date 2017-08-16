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
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class LeperGnome extends Minion {

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

    public LeperGnome(Player owner) {

        super(1, 1, 1, "Leper Gnome", owner,"Deathrattle: Deal 2 damage to the enemy hero.",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new LeperText(this));
    }

    private class LeperText extends Enchantments {

        private LeperText(CanHaveEnchantments link) {
            super(Keywords.DEATHRATTLE, "Deal two damage to your enemy", link);
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                UtilityMethods.findEnemy(board, owner).getHero().addHp(UtilityMethods.findEnemy(board, owner), -2);
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {

        }
    }
}