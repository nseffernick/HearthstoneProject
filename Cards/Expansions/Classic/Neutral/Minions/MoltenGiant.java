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

public class MoltenGiant extends Minion {

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

    public MoltenGiant(Player owner) {

        super(8, 8, 25, "Molten Giant", owner,"Costs (1) less for each damage your hero has taken.", Rarity.EPIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    private class MoltenGiantText extends Enchantments {

        private MoltenGiantText(CanHaveEnchantments link) {
            super(Keywords.UPDATECOSTFROMHEROHEALTH, "Less Health Less Cost", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                int defaultCost = 25;
                int set = owner.getHero().getMaxHP() - owner.getHero().getHp();
                cost = defaultCost - set;
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {

        }
    }
}
