package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/11/2017.
 */
public class StormwindKnight extends Minion {
    // State
    public int hp = 5;
    public int atk = 2;
    public int cost = 4;
    public String name = "Stormwind Knight";
    private String text = "Charge";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public StormwindKnight(Player owner) {

        super(5, 2, 4, "Stormwind Knight", owner, "Charge", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
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
