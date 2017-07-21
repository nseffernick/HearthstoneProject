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
    public int hp = 5;
    public int atk = 4;
    public int cost = 4;
    public String name = "Chillwind Yeti";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public ChillwindYeti(Player owner) {

        super(1, 5, 3, "Chillwind Yeti", owner,"", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
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