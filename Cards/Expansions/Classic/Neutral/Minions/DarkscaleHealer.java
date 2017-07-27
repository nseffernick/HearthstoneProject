package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Darkscale Healer Minion
 */
public class DarkscaleHealer extends Minion {

    // State
    protected int hp = 5;
    protected int atk = 4;
    protected int cost = 5;
    protected String name = "Darkscale Healer";
    protected String text = "Battlecry: Restore two Health to friendly characters";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public DarkscaleHealer(Player owner) {

        super(5, 4, 5, "Darkscale Healer", owner,
                "Battlecry: Restore two Health to friendly characters", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    // Heal all friendly characters for two health
    public void battlecry(BoardState board, Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            MasterTargeter.TargetAll(true, board.findEnemy(owner), -2);
        }
    }
}