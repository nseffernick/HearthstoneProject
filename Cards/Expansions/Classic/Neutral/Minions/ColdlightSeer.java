package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class ColdlightSeer extends Minion {

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

    public ColdlightSeer(Player owner) {

        super(3, 2, 3, "Coldlight Seer", owner,
                "Battlecry: Give all friendly murlocs +2 health.", Rarity.RARE,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    public void battlecry(BoardState board, Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            for (Minion minion: owner.getPlayerSide()) {
                if (minion.getTribe() == Tribe.MURLOC) {
                    minion.addMaxHP(2);
                    minion.addHp(2, board);
                }
            }
        }
    }
}
