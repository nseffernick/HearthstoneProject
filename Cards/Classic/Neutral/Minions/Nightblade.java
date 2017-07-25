package Cards.Classic.Neutral.Minions;

import Cards.Minion;
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
public class Nightblade extends Minion {

    // State
    protected int hp = 4;
    protected int atk = 4;
    protected int cost = 5;
    protected String name = "Nightblade";
    protected String text = "Battlecry: Deal 3 damage to the enemy hero";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public Nightblade(Player owner) {

        super(4, 4, 5, "Nightblade", owner,
                "Battlecry: Deal 3 damage to the enemy hero", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    // Deal three damage to hero
    public void battlecry(BoardState board, Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            MasterTargeter.Main(board.findEnemy(owner), -1, 3, null, true);
        }
    }
}
