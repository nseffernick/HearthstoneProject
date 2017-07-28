package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Dalaran Mage Minion
 */
public class DalaranMage extends Minion {

    // State
    protected int hp = 4;
    protected int atk = 1;
    protected int cost = 3;
    protected String name = "Dalaran Mage";
    protected String text = "Spell Damage +1";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public DalaranMage(Player owner) {

        super(4, 1, 3, "Dalaran Mage", owner,"Spell Damage +1", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.SPELLDAMAGE);
    }

}