package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Archmage Minion
 */
public class Archmage extends Minion {

    // State
    public int hp = 7;
    public int atk = 4;
    public int cost = 6;
    public String name = "Archmage";
    private String text = "Spell Damage +1";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public Archmage() {

        super(7, 4, 6, "Archmage", "Spell Damage +1", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.SPELLDAMAGE);
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