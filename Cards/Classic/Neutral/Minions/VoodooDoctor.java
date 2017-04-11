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
public class VoodooDoctor extends Minion {
    // State
    public int hp = 1;
    public int atk = 2;
    public int cost = 1;
    public String name = "Voodoo Doctor";
    private String text = "Battlecry: Restore 2 health";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public VoodooDoctor() {

        super(1, 2, 1, "Voodoo Doctor", "Battlecry: Restore 2 health", Rarity.BASIC,
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
