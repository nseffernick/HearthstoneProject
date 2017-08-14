package Cards.Expansions.Classic.Uncollectible.Paladin.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Enchantments.Structure.Keywords;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/27/2017. nxs1720@g.rit.edu
 */
public class SilverHand extends Minion {

    // State
    protected int hp;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Keywords> properties;

    public SilverHand(Player owner) {

        super(1, 1, 1, "Silver Hand Recruit", owner, "", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.PALADIN, new ArrayList<Keywords>());
    }
}
