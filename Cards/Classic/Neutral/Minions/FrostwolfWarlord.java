package Cards.Classic.Neutral.Minions;

import Cards.Minion;
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
    protected String text = "";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public FrostwolfWarlord(Player owner) {

        super(4, 4, 5, "Frostwolf Warlord", owner,"", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    public void battlecry(BoardState board, Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            int set = board.findEnemy(owner).getPlayerSide().size();
            addAtk(set);
            addMaxHP(set);
            addHp(set);
        }
    }
}