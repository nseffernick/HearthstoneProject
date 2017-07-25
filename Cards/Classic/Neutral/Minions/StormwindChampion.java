package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Auras.Aura;
import Game.Auras.StormwindChampionAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/11/2017.
 */
public class StormwindChampion extends Minion {

    // State
    protected int hp = 6;
    protected int atk = 6;
    protected int cost = 7;
    protected String name = "Stormwind Champion";
    protected String text = "Your other minions have +1/+1";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public StormwindChampion(Player owner) {

        super(6, 6, 7, "Stormwind Champion", owner,
                "Your other minions have +1/+1", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.AURA);
    }

    public void createAura(BoardState board) {
        Aura thisAura = new StormwindChampionAura(this, "Grimscale Oracle Aura");
        board.addAura(thisAura);
    }

}
