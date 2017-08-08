package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class ColdlightOracle extends Minion {

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

    public ColdlightOracle(Player owner) {

        super(2, 2, 3, "Coldlight Oracle", owner,
                "Battlecry: Each player draws two cards.", Rarity.RARE,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    public void battlecry(BoardState board, Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            owner.drawCard();
            owner.drawCard();
            UtilityMethods.findEnemy(board, owner).drawCard();
            UtilityMethods.findEnemy(board, owner).drawCard();
        }
    }
}
