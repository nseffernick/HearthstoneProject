package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/11/2017.
 */
public class SilverbackPatriarch extends Minion {

    // State
    protected int hp = 4;
    protected int atk = 1;
    protected int cost = 3;
    protected String name = "Silverback Patriarch";
    protected String text = "Taunt";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.BEAST;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public SilverbackPatriarch(Player owner) {

        super(4, 1, 3, "Silverback Patriarch", owner,"Taunt", Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.TAUNT);
    }

}
