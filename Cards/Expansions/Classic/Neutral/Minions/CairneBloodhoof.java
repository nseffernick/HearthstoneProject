package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Tokens.BaineBloodhoof;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class CairneBloodhoof extends Minion {

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

    public CairneBloodhoof(Player owner) {

        super(5, 4, 6, "Cairne Bloodhoof", owner, "Deathrattle: Summon a 4/5 Baine Bloodhoof.",
                Rarity.LEGENDARY, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.DEATHRATTLE);
    }

    @Override
    public void deathrattle(BoardState board) {
        if (properties.contains(Keywords.DEATHRATTLE)) {
            owner.summonCard(new BaineBloodhoof(owner), board);
        }
    }
}