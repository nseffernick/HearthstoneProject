package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Auras.Aura;
import Game.Auras.PintSizedSummonerAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class PintSizedSummoner extends Minion {

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

    public PintSizedSummoner(Player owner) {

        super(2, 2, 2, "Pint Sized Summoner", owner,"The first minion you play each turn costs (1) less.", Rarity.RARE,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        //properties.add(Keywords.AURA);
    }

    public void createAura(BoardState board) {
        Aura thisAura = new PintSizedSummonerAura(this, "Pint Sized Summoner Aura");
        owner.addAura(thisAura, board);
    }

    public void disableAura() {

    }
}