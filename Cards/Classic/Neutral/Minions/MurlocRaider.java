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
public class MurlocRaider extends Minion {
    // State
    public int hp = 1;
    public int atk = 2;
    public int cost = 1;
    public String name = "Murloc Raider";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public MurlocRaider() {

        super(1, 2, 1, "Murloc Raider", "", Rarity.BASIC,
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
