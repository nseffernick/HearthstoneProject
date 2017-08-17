package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.Gnoll;
import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.VioletApprentice;
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

public class VioletTeacher extends Minion {

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

    public VioletTeacher(Player owner) {

        super(5, 3, 4, "Violet Teacher", owner,"After you cast a spell, summon a 1/1 Violet Apprentice",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new VioletText(this));
    }

    private class VioletText extends Enchantments {

        private VioletText(CanHaveEnchantments link) {
            super(Keywords.SPELLCASTED, "Spawn Students", link);
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
                owner.summonMinion(new VioletApprentice(owner), board);
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {

        }
    }
}