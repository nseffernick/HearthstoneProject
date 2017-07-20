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
public class GnomishInventor extends Minion {
    // State
    public int hp = 4;
    public int atk = 2;
    public int cost = 4;
    public String name = "Gnomish Inventor";
    private String text = "Battlecry: Draw a Card";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public GnomishInventor() {

        super(7, 6, 6, "Gnomish Inventor", "Battlecry: Draw a Card", Rarity.BASIC,
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

    public void battlecry() {
        if (properties.contains(Keywords.BATTLECRY)) {
            findPlayer(1).drawCard();
        }
    }
}
