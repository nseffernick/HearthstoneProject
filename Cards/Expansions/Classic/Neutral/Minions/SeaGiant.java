package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
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
    protected ArrayList<Keywords> properties;

    public SeaGiant(Player owner) {

        super(8, 8, 12, "Mountain Giant", owner,"Costs (1) less for each card you have in your hand.", Rarity.EPIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }

    @Override
    public void updateCostFromBoardSize(BoardState board) {
        int defaultCost = 10;
        int set = owner.getPlayerSide().size();
        int set1 = UtilityMethods.findEnemy(board, owner).getPlayerSide().size();

        cost = defaultCost - set - set1;
    }
}
