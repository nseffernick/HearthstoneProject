package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Enchantments.Structure.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Bloodfen Raptor Minion
 */
public class BloodfenRaptor extends Minion {

    // State
    protected int hp = 2;
    protected int atk = 3;
    protected int cost = 2;
    protected String name = "Bloodfen Raptor";
    protected String text = "";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.BEAST;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public BloodfenRaptor(Player owner) {

        super(2, 3, 2, "Bloodfen Raptor", owner, "", Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }

}