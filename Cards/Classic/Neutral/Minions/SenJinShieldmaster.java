package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Sen'Jin Shieldmaster Minion
 */
public class SenJinShieldmaster extends Minion {

    // State
    public int hp = 5;
    public int atk = 3;
    public int cost = 4;
    public String name = "Sen'Jin Shieldmaster";
    public String text = "Taunt";
    public Rarity rarity = Rarity.BASIC;
    public Tribe tribe = Tribe.GENERAL;
    public HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public SenJinShieldmaster() {

        super(5, 3, 4, "Sen'Jin Shieldmaster", "Taunt", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.TAUNT);
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