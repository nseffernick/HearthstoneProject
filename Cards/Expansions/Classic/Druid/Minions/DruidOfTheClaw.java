package Cards.Expansions.Classic.Druid.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class DruidOfTheClaw extends Minion {

    // State
    protected int hp;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Keywords> properties;


    public DruidOfTheClaw(Player owner) {

        super(4, 4, 5, "Druid of the Claw", owner,"Choose One - Transform into a 4/4 with Charge;" +
                        " or a 4/6 with Taunt.", Rarity.BASIC, Tribe.GENERAL, HeroClass.DRUID, new ArrayList<Keywords>());
        properties.add(Keywords.CHOOSEONE);
    }



}