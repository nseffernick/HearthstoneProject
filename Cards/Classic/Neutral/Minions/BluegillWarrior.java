package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Bluegill Warrior Minion
 */
public class BluegillWarrior extends Minion {

    // State
    protected int hp = 1;
    protected int atk = 2;
    protected int cost = 2;
    protected String name = "Bluegill Warrior";
    protected String text = "Charge";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.MURLOC;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public BluegillWarrior(Player owner) {

        super(1, 2, 2, "Bluegill Warrior", owner, "Charge", Rarity.BASIC,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.CHARGE);
    }

}