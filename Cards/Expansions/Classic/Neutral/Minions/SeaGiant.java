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

        super(8, 8, 10, "Sea Giant", owner,"Costs (1) less for each minion on the board.", Rarity.EPIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new SeaGiantText(this));
    }

    private class SeaGiantText extends Enchantments {

        private SeaGiantText(CanHaveEnchantments link) {
            super(Keywords.UPDATECOSTFROMBOARDSIZE, "More Minions Less Cost", link);
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            int defaultCost = 10;
            int set = owner.getPlayerSide().size();
            int set1 = UtilityMethods.findEnemy(board, owner).getPlayerSide().size();
            cost = defaultCost - set - set1;
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {
        }
    }
}
