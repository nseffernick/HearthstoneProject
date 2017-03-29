package Cards.Classic.Warlock.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/26/2017.
 */
public class Jaraxxus extends Minion {

    // State
    private int hp = 15;
    private int atk = 3;
    private int cost = 9;
    private String name = "Jaraxxus";
    private String text = "Battlecry: Destroy your hero and replace it with" +
            "Lord Jaraxxus";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public Jaraxxus(int hp, int atk, int cost, String name, String text,
                    ArrayList<Keywords> properties) {

        super(hp, atk, cost, name, text, Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, properties);

        properties.add(Keywords.DELTACOST);

    }
}