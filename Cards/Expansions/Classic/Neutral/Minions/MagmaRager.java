package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Magma Rager Minion
 */
public class MagmaRager extends Minion {

    // State
    protected int hp = 1;
    protected int atk = 5;
    protected int cost = 3;
    protected String name = "Magma Rager";
    protected String text = "";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.ELEMENTAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public MagmaRager(Player owner) {

        super(1, 5, 3, "Magma Rager", owner,"", Rarity.BASIC,
                Tribe.ELEMENTAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }

}