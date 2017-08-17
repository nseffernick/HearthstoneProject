package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Auras.Aura;
import Game.Auras.StormwindChampionAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/11/2017.
 */
public class StormwindChampion extends Minion {

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

    public StormwindChampion(Player owner) {

        super(6, 6, 7, "Stormwind Champion", owner,
                "Your other minions have +1/+1", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        //properties.add(Keywords.AURA);
    }

    public void createAura(BoardState board) {
        Aura thisAura = new StormwindChampionAura(this, "Grimscale Oracle Aura");
        owner.addAura(thisAura, board);
    }

}
