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
    protected int hp = 5;
    protected int atk = 4;
    protected int cost = 6;
    protected String name = "Windfury Harpy";
    protected String text = "Windfury";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public WindfuryHarpy(Player owner) {

        super(5, 4, 6, "Windfury Harpy", owner,"Windfury", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());

        properties.add(Keywords.WINDFURY);
    }


}