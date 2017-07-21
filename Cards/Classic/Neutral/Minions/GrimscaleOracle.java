package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Auras.Aura;
import Game.Auras.GrimscaleOracleAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class GrimscaleOracle extends Minion {
    // State
    public int hp = 1;
    public int atk = 1;
    public int cost = 1;
    public String name = "Grimscale Oracle";
    private String text = "Your other murlocs have +1 Attack";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.MURLOC;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public GrimscaleOracle(Player owner) {

        super(1, 1, 1, "Grimscale Oracle", owner,
                "Your other murlocs have +1 Attack", Rarity.BASIC,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.AURA);
    }

    public void createAura(BoardState board) {
        Aura thisAura = new GrimscaleOracleAura(this, "Grimscale Oracle Aura");
        board.addAura(thisAura);
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
