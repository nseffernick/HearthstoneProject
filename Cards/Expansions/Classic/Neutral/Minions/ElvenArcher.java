package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Enchantments.Structure.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Elven Archer Minion
 */
public class ElvenArcher extends Minion {

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


    public ElvenArcher(Player owner) {

        super(1, 1, 1, "Elven Archer", owner, "Battlecry: Deal 1 damage", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    // Deal one damage
    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (properties.contains(Keywords.BATTLECRY)) {
            MasterTargeter.Main(player.promptTargetPlayer(board), player.promptTargetIndex(board, 0), 1, null, true, board);
        }
    }
}