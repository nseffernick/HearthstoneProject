package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Acidic Swamp Ooze Minion
 */
public class AcidicSwampOoze extends Minion {

    // State
    public int hp = 2;
    public int atk = 3;
    public int cost = 2;
    public String name = "Acidic Swamp Ooze";
    private String text = "Battlecry: Destroy the opponent's weapon";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public AcidicSwampOoze() {

        super(3, 2, 2, "Acidic Swamp Ooze",
                "Battlecry: Destroy the opponent'w weapon", Rarity.BASIC,
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

    @Override
    public void battlecry() {
        if (properties.contains(Keywords.BATTLECRY)) {
            // If player has weapon then remove it lol
        }
    }
}