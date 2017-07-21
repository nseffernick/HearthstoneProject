package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class GurubashiBerserker extends Minion {
    // State
    public int hp = 7;
    public int atk = 2;
    public int cost = 5;
    public String name = "Gurubashi Berserker";
    private String text = "";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.GENERAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public GurubashiBerserker(Player owner) {

        super(7, 2, 5, "Gurubashi Berserker", owner,
                "Whenever this minion takes damage, gain +3 Attack", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.WHENEVER);
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
