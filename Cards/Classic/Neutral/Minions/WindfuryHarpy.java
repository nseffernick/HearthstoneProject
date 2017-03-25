package Cards.Classic.Neutral.Minions;

import Cards.Minion;
//import Utility.Effects.Property;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/21/2017. nxs1720@g.rit.edu
 */
public class WindfuryHarpy extends Minion {

    // State
    private int hp = 5;
    private int atk = 4;
    private int cost = 6;
    private String name = "Windfury Harpy";
    private String text = "Windfury";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public WindfuryHarpy(int hp, int atk, int cost, String name, String text,
                     ArrayList<Keywords> properties) {

        super(hp, atk, cost, name, text, Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, properties);

        properties.add(Keywords.WINDFURY);
    }



}