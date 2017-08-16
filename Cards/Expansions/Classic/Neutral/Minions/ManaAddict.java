package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.Gnoll;
import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.TemporaryEnchantment;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class ManaAddict extends Minion {

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

    public ManaAddict(Player owner) {

        super(3, 1, 2, "Mana Addict", owner,"Whenever you cast a spell, gain +2 Attack this turn.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new ManaAddictText(this));
    }

    private class ManaAddictText extends Enchantments implements TemporaryEnchantment{

        private int numCasted;

        private ManaAddictText(CanHaveEnchantments link) {
            super(Keywords.SPELLCASTED, "Gain Attack", link);
            numCasted = 0;
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                minionLink.addAtk(2);
                numCasted += 1;
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                minionLink.addAtk(-2*numCasted);
            }
            numCasted = 0;
        }

        @Override
        public void temporaryDisenchant(BoardState board, Minion minion) {
            disenchant(board, minion);
        }
    }
}
