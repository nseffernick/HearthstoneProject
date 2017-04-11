package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Bluegill Warrior Minion
 */
public class BluegillWarrior extends Minion {

    // State
    public int hp = 1;
    public int atk = 2;
    public int cost = 2;
    public String name = "Bluegill Warrior";
    private String text = "Charge";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public BluegillWarrior() {

        super(1, 2, 2, "Bluegill Warrior", "Charge", Rarity.BASIC,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.CHARGE);
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