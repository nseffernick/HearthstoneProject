package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/11/2017.
 */
public class StormpikeCommando extends Minion {
    // State
    public int hp = 2;
    public int atk = 4;
    public int cost = 5;
    public String name = "Stormpike Commando";
    private String text = "Battlecry: Deal 2 damage";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public StormpikeCommando() {

        super(2, 4, 5, "Stormpike Commando", 
                "Battlecry: Deal 2 damage", Rarity.BASIC,
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
}
