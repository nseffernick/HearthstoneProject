package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
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
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.GENERAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public WindfuryHarpy(Player owner) {

        super(5, 4, 6, "Windfury Harpy", owner,"Windfury", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());

        properties.add(Keywords.WINDFURY);
    }



}