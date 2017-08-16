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

public class SeaGiant  extends Minion {

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

    public SeaGiant(Player owner) {

        super(8, 8, 12, "Mountain Giant", owner,"Costs (1) less for each card you have in your hand.", Rarity.EPIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void updateCostFromBoardSize(BoardState board) {
        int defaultCost = 10;
        int set = owner.getPlayerSide().size();
        int set1 = UtilityMethods.findEnemy(board, owner).getPlayerSide().size();

        cost = defaultCost - set - set1;
    }

    private class SeaGiantText extends Enchantments {

        private SeaGiantText(CanHaveEnchantments link) {
            super(Keywords.UPDATECOSTFROMBOARDSIZE, "More Minions Less Cost", link);
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                int defaultCost = 10;
                int set = owner.getPlayerSide().size();
                int set1 = UtilityMethods.findEnemy(board, owner).getPlayerSide().size();
                cost = defaultCost - set - set1;
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {
        }
    }
}
