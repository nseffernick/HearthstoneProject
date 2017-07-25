package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Oasis Snapjaw Minion
 */
public class OasisSnapjaw extends Minion {

    // State
    protected int hp = 7;
    protected int atk = 2;
    protected int cost = 4;
    protected String name = "Oasis Snapjaw";
    protected String text = "";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.BEAST;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public OasisSnapjaw(Player owner) {

        super(7, 2, 4, "Oasis Snapjaw", owner,"", Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }

}
