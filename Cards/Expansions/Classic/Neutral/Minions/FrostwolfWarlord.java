package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class FrostwolfWarlord extends Minion {

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

    public FrostwolfWarlord(Player owner) {

        super(4, 4, 5, "Frostwolf Warlord", owner,
                "Battlecry: Gain +X/+X for each " + "friendly minion on the board", Rarity.BASIC, Tribe.GENERAL,
                HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        int set = player.getPlayerSide().size();
        addAtk(set);
        addMaxHP(set);
        addHp(set, board);
    }
}