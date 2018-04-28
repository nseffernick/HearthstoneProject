package Cards.Expansions.Classic.Neutral.Minions;

import Game.CanHaveEnchantments;
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

public class WildPyromancer extends Minion {

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

    public WildPyromancer(Player owner) {

        super(2, 3, 2, "Wild Pyromancer", owner,"After you cast a spell, deal 1 damage to ALL minions.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new PyroText(this));
    }

    private class PyroText extends Enchantments {

        private PyroText(CanHaveEnchantments link) {
            super(Keywords.SPELLCASTED, "Deal one damage to all Minions", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            damageToAllMinions(board, 1);
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {

        }
    }
}