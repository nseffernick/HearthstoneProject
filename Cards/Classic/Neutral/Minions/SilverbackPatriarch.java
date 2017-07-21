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
    public int hp = 4;
    public int atk = 1;
    public int cost = 3;
    public String name = "Silverback Patriarch";
    private String text = "Taunt";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.BEAST;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public SilverbackPatriarch(Player owner) {

        super(4, 1, 3, "Silverback Patriarch", owner,"Taunt", Rarity.BASIC,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
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
