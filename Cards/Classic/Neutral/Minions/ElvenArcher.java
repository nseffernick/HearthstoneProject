package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Elven Archer Minion
 */
public class ElvenArcher extends Minion {

    // State
    public int hp = 1;
    public int atk = 1;
    public int cost = 1;
    public String name = "Elven Archer";
    private String text = "";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.GENERAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public ElvenArcher(Player owner) {

        super(1, 1, 1, "Elven Archer", owner, "Taunt", Rarity.BASIC,
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

    // Deal one damage
    public void battlecry(Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            MasterTargeter.Main(player, index, 1, null);
        }
    }
}