package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Enchantments.Structure.Keywords;

import java.util.ArrayList;

/**
 * Representation of the River Crocolisk Minion
 */
public class ArgentCommander extends Minion {

    // State
    protected int hp = 2;
    protected int atk = 4;
    protected int cost = 6;
    protected String name = "Argent Commander";
    protected String text = "Charge\n Divine Shield";
    protected Rarity rarity = Rarity.RARE;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public ArgentCommander(Player owner) {

        super(2, 4, 6, "Argent Commander", owner,
                "Charge\n Divine Shield", Rarity.RARE,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.CHARGE);
        properties.add(Keywords.DIVINESHIELD);
    }

}