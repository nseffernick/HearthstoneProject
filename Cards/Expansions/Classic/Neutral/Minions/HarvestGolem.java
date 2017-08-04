package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Tokens.DamagedGolem;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class HarvestGolem extends Minion {

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

    public HarvestGolem(Player owner) {

        super(3, 2, 3, "Harvest Golem", owner, "Deathrattle: Summon a 2/1 Damaged Golem.",
                Rarity.COMMON, Tribe.MECH, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.DEATHRATTLE);
    }

    @Override
    public void deathrattle(BoardState board) {
        owner.summonCard(new DamagedGolem(owner), board);
    }
}