package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Chillwind Yeti Minion
 * muh nicely statted not a beast because reasons minion
 */
public class ChillwindYeti extends Minion {

    // State
    protected int hp = 5;
    protected int atk = 4;
    protected int cost = 4;
    protected String name = "Chillwind Yeti";
    protected String text = "";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public ChillwindYeti(Player owner) {

        super(1, 5, 3, "Chillwind Yeti", owner,"", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }

}