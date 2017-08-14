package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class RagingWorgen extends Minion {

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

    public RagingWorgen(Player owner) {

        super(3, 3, 3, "Raging Worgen", owner,"Enrage: Windfury and +1 Attack.",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.ENRAGE);
    }

    @Override
    public void enrage() {
        if (enraged) {
            addAtk(-1);
            properties.remove(Keywords.WINDFURY);
        }
        else {
            addAtk(1);
            properties.add(Keywords.WINDFURY);
        }
    }
}