package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Dalaran Mage Minion
 */
public class DalaranMage extends Minion {

    // State
    public int hp = 4;
    public int atk = 1;
    public int cost = 3;
    public String name = "Dalaran Mage";
    private String text = "";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.GENERAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public DalaranMage(Player owner) {

        super(4, 1, 3, "Dalaran Mage", owner,"", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.SPELLDAMAGE);
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