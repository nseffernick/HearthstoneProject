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
    protected int hp = 3;
    protected int atk = 3;
    protected int cost = 3;
    protected String name = "Ironfur Grizzly";
    protected String text = "";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.BEAST;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public IronfurGrizzly(Player owner) {

        super(3, 3, 3, "Ironfur Grizzly", owner,"", Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.TAUNT);
    }

}
