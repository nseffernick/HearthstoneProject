package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class Nightblade extends Minion {

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

    public Nightblade(Player owner) {

        super(4, 4, 5, "Nightblade", owner,
                "Battlecry: Deal 3 damage to the enemy hero", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    // Deal three damage to hero
    @Override
    public void battlecry(BoardState board, Player player, int position) {
        MasterTargeter.Main(UtilityMethods.findEnemy(board, player), -1, -3, null, true, board);
    }
}
