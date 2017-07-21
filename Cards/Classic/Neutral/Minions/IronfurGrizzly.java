package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class IronfurGrizzly extends Minion {
    // State
    public int hp = 3;
    public int atk = 3;
    public int cost = 3;
    public String name = "Ironfur Grizzly";
    private String text = "";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.BEAST;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public IronfurGrizzly(Player owner) {

        super(3, 3, 3, "Ironfur Grizzly", owner,"", Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
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
