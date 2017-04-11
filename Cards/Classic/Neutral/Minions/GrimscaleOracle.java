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
public class GrimscaleOracle extends Minion {
    // State
    public int hp = 1;
    public int atk = 1;
    public int cost = 1;
    public String name = "Grimscale Oracle";
    private String text = "Your other murlocs have +1 Attack";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public GrimscaleOracle() {

        super(1, 1, 1, "Grimscale Oracle",
                "Your other murlocs have +1 Attack", Rarity.BASIC,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Keywords>());
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
