package Cards.Classic.Neutral.Minions;

import Cards.Minion;
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
    public int hp = 5;
    public int atk = 4;
    public int cost = 5;
    public String name = "Darkscale Healer";
    private String text = "Battlecry: Restore two Health to friendly characters";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.GENERAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public DarkscaleHealer(Player owner) {

        super(5, 4, 5, "Darkscale Healer", owner,
                "Battlecry: Restore two Health to friendly characters", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }


    @Override
    public void onDeath() {

    }

    @Override
    public void onSummon() {

    }

    @Override
    public void onTurnStart() {

    }

    // Heal all friendly characters for two health
    public void battlecry(BoardState board) {
        if (properties.contains(Keywords.BATTLECRY)) {
            MasterTargeter.TargetAll(true, board.findEnemy(owner), -2);
        }
    }
}