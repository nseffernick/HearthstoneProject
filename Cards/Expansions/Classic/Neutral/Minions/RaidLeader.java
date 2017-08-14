package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Auras.Aura;
import Game.Auras.RaidLeaderAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Enchantments.Structure.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Raid Leader Minion
 */
public class RaidLeader extends Minion {

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

    public RaidLeader(Player owner) {

        super(2, 2, 3, "Raid Leader", owner,"", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.AURA);
    }

    public void createAura(BoardState board) {
        Aura thisAura = new RaidLeaderAura(this, "Raid Leader Aura");
        owner.addAura(thisAura, board);
    }

}