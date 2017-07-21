package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Bloodfen Raptor Minion
 */
public class BloodfenRaptor extends Minion {

    // State
    public int hp = 2;
    public int atk = 3;
    public int cost = 2;
    public String name = "Bloodfen Raptor";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public BloodfenRaptor(Player owner) {

        super(2, 3, 2, "Bloodfen Raptor", owner, "", Rarity.BASIC,
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