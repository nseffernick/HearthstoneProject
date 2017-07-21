package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Oasis Snapjaw Minion
 */
public class OasisSnapjaw extends Minion {

    // State
    public int hp = 7;
    public int atk = 2;
    public int cost = 4;
    public String name = "Oasis Snapjaw";
    private String text = "";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.BEAST;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public OasisSnapjaw(Player owner) {

        super(7, 2, 4, "Oasis Snapjaw", owner,"", Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }


    @Override
    public void onDeath() {

    }

    @Override
    public void onSummon() {

    }

    @Override
    public void onTurnStart() {

    }
}
