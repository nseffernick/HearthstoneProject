package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class IronforgeRifleman extends Minion {

    // State
    protected int hp = 2;
    protected int atk = 2;
    protected int cost = 3;
    protected String name = "Ironforge Rifleman";
    protected String text = "Battlecry: Deal one damage";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public IronforgeRifleman(Player owner) {

        super(2, 2, 3, "Ironforge Rifleman", owner,
                "Battlecry: Deal one damage", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    // Deal one damage
    @Override
    public void battlecry(BoardState board, Player player) {
        if (properties.contains(Keywords.BATTLECRY)) {
            MasterTargeter.Main(player, player.promptTargetIndex(board, 0), 1, null, true, board);
        }
    }
}
