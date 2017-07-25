package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Auras.Aura;
import Game.Auras.RaidLeaderAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Raid Leader Minion
 */
public class RaidLeader extends Minion {

    // State
    protected int hp = 2;
    protected int atk = 2;
    protected int cost = 3;
    protected String name = "Raid Leader";
    protected String text = "";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public RaidLeader(Player owner) {

        super(2, 2, 3, "Raid Leader", owner,"", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.AURA);
    }

    public void createAura(BoardState board) {
        Aura thisAura = new RaidLeaderAura(this, "Raid Leader Aura");
        board.addAura(thisAura);
    }

}