package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/11/2017.
 */
public class VoodooDoctor extends Minion {

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

    public VoodooDoctor(Player owner) {

        super(1, 2, 1, "Voodoo Doctor", owner,"Battlecry: Restore 2 health", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    // Heal two health
    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (properties.contains(Keywords.BATTLECRY)) {
            MasterTargeter.Main(player.promptTargetPlayer(board), player.promptTargetIndex(board, 0) , 2, null, true, board);
        }
    }
}
