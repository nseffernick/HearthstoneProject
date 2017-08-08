package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class CultMaster extends Minion {

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

    public CultMaster(Player owner) {

        super(2, 4, 4, "Cult Master", owner,
                "Whenever one of your other minions dies, draw a card.", Rarity.COMMON,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.MINIONDEATH);
    }

    @Override
    public void minionDeath(Minion minion) {
        if (properties.contains(Keywords.MINIONDEATH)) {
            if (minion.getOwner() == owner) {
                owner.drawCard();
            }
        }
    }
}