package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class MoltenGiant extends Minion{

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

    public MoltenGiant(Player owner) {

        super(8, 8, 25, "Molten Giant", owner,"Costs (1) less for each damage your hero has taken.", Rarity.EPIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }

    @Override
    public void updateCostFromHeroHP() {
        int defaultCost = 25;
        int set = owner.getHero().getMaxHP() - owner.getHero().getHp();
        cost = defaultCost - set;
    }
}
