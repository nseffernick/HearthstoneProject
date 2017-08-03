package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
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
    protected int hp = 7;
    protected int atk = 2;
    protected int cost = 5;
    protected String name = "Gurubashi Berserker";
    protected String text = "";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public GurubashiBerserker(Player owner) {

        super(7, 2, 5, "Gurubashi Berserker", owner,
                "Whenever this minion takes damage, gain +3 Attack", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.ONHIT);
    }

    @Override
    public void onHit() {
        if (properties.contains(Keywords.ONHIT)) {
            addAtk(3);
        }
    }
}
