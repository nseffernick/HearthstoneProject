package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Goldshire Footman Minion
 */
public class GoldshireFootman extends Minion {

    // State
    public int hp = 2;
    public int atk = 1;
    public int cost = 1;
    public String name = "Goldshire Footman";
    private String text = "Taunt";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.GENERAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public GoldshireFootman(Player owner) {

        super(2, 1, 1, "Goldshire Footman", owner,"Taunt", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.TAUNT);
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