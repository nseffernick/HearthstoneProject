package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Boulderfist Ogre Minion
 */
public class BoulderfistOgre extends Minion {

    // State
    protected int hp = 7;
    protected int atk = 6;
    protected int cost = 6;
    protected String name = "Boulderfist Ogre";
    protected String text = "";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public BoulderfistOgre(Player owner) {

        super(7, 6, 6, "Boulderfist Ogre", owner, "", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }

}