package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class LordOfTheArena extends Minion {
    
    // State
    public int hp = 5;
    public int atk = 6;
    public int cost = 6;
    public String name = "Lord of the Arena";
    private String text = "Taunt";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public LordOfTheArena() {

        super(5, 6, 6, "Lord of the Arena", "Taunt", Rarity.BASIC,
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
