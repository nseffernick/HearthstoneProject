package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the River Crocolisk Minion
 */
public class RiverCrocolisk extends Minion {

    // State
    protected int hp = 3;
    protected int atk = 2;
    protected int cost = 2;
    protected String name = "River Crocolisk";
    protected String text = "";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.BEAST;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public RiverCrocolisk(Player owner) {

        super(3, 2, 2, "River Crocolisk", owner,"", Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }

}