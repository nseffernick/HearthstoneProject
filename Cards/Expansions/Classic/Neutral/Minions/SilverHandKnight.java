package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.Squire;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class SilverHandKnight extends Minion {

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


    public SilverHandKnight(Player owner) {

        super(4, 4, 4, "Silver Hand Knight", owner,
                "Battlecry: Summon a 2/2 Squire", Rarity.COMMON,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    // Summon a 2/1 dragonling
    public void battlecry(BoardState board, Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            owner.summonMinion(new Squire(owner), board);
        }
    }
}
