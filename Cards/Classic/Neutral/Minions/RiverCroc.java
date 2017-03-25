package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.Effects.Property;
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
    private int hp = 3;
    private int atk = 2;
    private int cost = 2;
    private String name = "River Crocolisk";
    private String text = "";
    private ArrayList<Property> properties = new ArrayList<>();

    public RiverCroc(int hp, int atk, int cost, String name, String text,
                     ArrayList<Property> properties) {

        super(hp, atk, cost, name, text, Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, properties);
    }


}