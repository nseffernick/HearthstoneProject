package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the River Crocolisk Minion
 */
public class RiverCroc extends Minion {

    // State
    public int hp = 3;
    public int atk = 2;
    public int cost = 2;
    public String name = "River Crocolisk";
    private String text = "";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.BEAST;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public RiverCroc(Player owner) {

        super(3, 2, 2, "River Crocolisk", owner,"", Rarity.BASIC,
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