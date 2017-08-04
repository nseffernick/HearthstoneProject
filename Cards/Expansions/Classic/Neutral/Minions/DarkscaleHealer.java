package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

/**
 * Representation of the Darkscale Healer Minion
 */
public class DarkscaleHealer extends Minion {

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


    //TODO Prolly fix this card
    public DarkscaleHealer(Player owner) {

        super(5, 4, 5, "Darkscale Healer", owner,
                "Battlecry: Restore two Health to friendly characters", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    // Heal all friendly characters for two health
    @Override
    public void battlecry(BoardState board, Player player) {
        if (properties.contains(Keywords.BATTLECRY)) {
            MasterTargeter.TargetAll(true, owner, -2, board);
        }
    }
}