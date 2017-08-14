package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Auras.Aura;
import Game.Auras.GrimscaleOracleAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class GrimscaleOracle extends Minion {

    // State
    protected int hp = 1;
    protected int atk = 1;
    protected int cost = 1;
    protected String name = "Grimscale Oracle";
    protected String text = "Your other murlocs have +1 Attack";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.MURLOC;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public GrimscaleOracle(Player owner) {

        super(1, 1, 1, "Grimscale Oracle", owner,
                "Your other murlocs have +1 Attack", Rarity.BASIC,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.AURA);
    }

    public void createAura(BoardState board) {
        Aura thisAura = new GrimscaleOracleAura(this, "Grimscale Oracle Aura");
        owner.addAura(thisAura, board);
    }

}
