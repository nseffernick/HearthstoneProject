package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class SunfuryProtector extends Minion {

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

    public SunfuryProtector(Player owner) {

        super(3, 2, 2, "Sunfury Protector", owner, "Battlecry: Give adjacent minions taunt.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        Minion left = null;
        if (position == 0);
        else {
            left = owner.getPlayerSide().get(position - 1);
        }
        Minion right = null;
        if (position == owner.getPlayerSide().size());
        else {
            right = owner.getPlayerSide().get(position);
        }
        if (left != null) {
            left.getProperties().add(Keywords.TAUNT);
        }
        if (right != null) {
            right.getProperties().add(Keywords.TAUNT);
        }
    }
}