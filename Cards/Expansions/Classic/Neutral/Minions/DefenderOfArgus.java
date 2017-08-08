package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class DefenderOfArgus extends Minion {

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

    public DefenderOfArgus(Player owner) {

        super(3, 2, 4, "Defender of Argus", owner, "Battlecry: Give adjacent minions taunt and +1/+1",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    //TODO buffs shouldnt count as healing lmaoooooaoaoaoaoaoaao
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
            left.addMaxHP(1);
            left.addHp(1, board);
            left.addAtk(1);
        }
        if (right != null) {
            right.getProperties().add(Keywords.TAUNT);
            right.addMaxHP(1);
            right.addHp(1, board);
            right.addAtk(1);
        }
    }
}