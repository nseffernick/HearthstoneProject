package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the River Crocolisk Minion
 */
public class ArgentCommander extends Minion {

    // State
    public int hp = 2;
    public int atk = 4;
    public int cost = 6;
    public String name = "Argent Commander";
    public String text = "Charge\n Divine Shield";
    public Rarity rarity = Rarity.RARE;
    public Tribe tribe = Tribe.GENERAL;
    public HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public ArgentCommander() {

        super(2, 4, 6, "Argent Commander",
                "Charge\n Divine Shield", Rarity.RARE,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.CHARGE);
        properties.add(Keywords.DIVINESHIELD);
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