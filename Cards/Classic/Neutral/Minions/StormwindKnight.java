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
    protected int hp = 5;
    protected int atk = 2;
    protected int cost = 4;
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected String name = "Stormwind Knight";
    protected String text = "Charge";
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public StormwindKnight(Player owner) {

        super(5, 2, 4, "Stormwind Knight", owner, "Charge", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.CHARGE);
    }

}
