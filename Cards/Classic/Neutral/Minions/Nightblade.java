package Cards.Classic.Neutral.Minions;

import Cards.Minion;
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
    public int hp = 4;
    public int atk = 4;
    public int cost = 5;
    public String name = "Nightblade";
    private String text = "Battlecry: Deal 3 damage to the enemy hero";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public Nightblade() {

        super(4, 4, 5, "Nightblade",
                "Battlecry: Deal 3 damage to the enemy hero", Rarity.BASIC,
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

    // Deal two damage
    public void battlecry() {
        if (properties.contains(Keywords.BATTLECRY)) {
            MasterTargeter.Main(findPlayer(2), -1, 3, null);
        }
    }
}
