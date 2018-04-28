package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Auras.Aura;
import Game.Auras.GrimscaleOracleAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
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
    protected int hp;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Enchantments> enchantments;

    public GrimscaleOracle(Player owner) {
        // TODO Auras and enchantments, should be really easy actually
        super(1, 1, 1, "Grimscale Oracle", owner,
                "Your other murlocs have +1 Attack", Rarity.BASIC,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(null);
    }

    public void createAura(BoardState board) {
        Aura thisAura = new GrimscaleOracleAura(this, "Grimscale Oracle Aura");
        owner.addAura(thisAura, board);
    }

}
