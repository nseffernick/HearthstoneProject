package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Tokens.FlameOfAzzinoth;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class IllidanStormrage extends Minion {

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

    public IllidanStormrage(Player owner) {

        super(5, 7, 6, "Illidan Stormrage", owner,"Whenever you play a card, summon a 2/1 Flame of Azzinoth.",
                Rarity.LEGENDARY, Tribe.DEMON, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.CARDPLAYED);
    }

    @Override
    public void cardPlayed(BoardState board) {
        if (properties.contains(Keywords.CARDPLAYED)) {
            owner.summonCard(new FlameOfAzzinoth(owner), board);
        }
    }
}
