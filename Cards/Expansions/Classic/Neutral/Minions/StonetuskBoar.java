package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Stonetusk Boar Minion
 */
public class StonetuskBoar extends Minion {

    // State
    protected int hp = 1;
    protected int atk = 1;
    protected int cost = 1;
    protected String name = "Stonetusk Boar";
    protected String text = "Charge";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.BEAST;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public StonetuskBoar(Player owner) {

        super(1, 1, 1, "Stonetusk Boar", owner,"Charge", Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.CHARGE);
    }

}