package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Raid Leader Minion
 */
public class RaidLeader extends Minion {

    // State
    public int hp = 2;
    public int atk = 2;
    public int cost = 3;
    public String name = "Raid Leader";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public RaidLeader() {

        super(2, 2, 3, "Raid Leader", "", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
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
}