package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
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
public class FrostwolfWarlord extends Minion {

    // State
    protected int hp = 4;
    protected int atk = 4;
    protected int cost = 5;
    protected String name = "Frostwolf Warlord";
    protected String text = "Battlecry: Gain +X/+X for each friendly minion on the board";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public FrostwolfWarlord(Player owner) {

        super(4, 4, 5, "Frostwolf Warlord", owner,
                "Battlecry: Gain +X/+X for each " + "friendly minion on the board", Rarity.BASIC, Tribe.GENERAL,
                HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player) {
        if (properties.contains(Keywords.BATTLECRY)) {
            int set = player.getPlayerSide().size();
            addAtk(set);
            addMaxHP(set);
            addHp(set, board);
        }
    }
}