package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Auras.Aura;
import Game.Auras.GrimscaleOracleAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Enchantments.Structure.Keywords;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/21/2017. nxs1720@g.rit.edu
 *
 **/
public class VentureCoMerc extends Minion {

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

    public VentureCoMerc(Player owner) {

        super(6, 7, 5, "Venture Co. Mercenary", owner,
                "Your minions cost 3 more.", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        //properties.add(Keywords.AURA);
    }

    public void createAura(BoardState board) {

        Aura thisAura = new GrimscaleOracleAura(this, "Grimscale Oracle Aura");
        owner.addAura(thisAura, board);
    }

}