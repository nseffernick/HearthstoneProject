package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class AbusiveSergeant extends Minion {

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

    public AbusiveSergeant(Player owner) {

        super(1, 1, 1, "Angry Chicken", owner,"", Rarity.RARE,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    //TODO this
    @Override
    public void battlecry(BoardState board, Player player) {
        if (properties.contains(Keywords.BATTLECRY)) {
            int index = player.promptTargetIndex(board, 3);
            if (index == 10);
            else if (Targeting.characterTargeting(owner, index, true)) {
                Minion minion = owner.getPlayerSide().get(index);
                minion.addAtk(1);
                minion.addMaxHP(1);
                minion.addHp(1, board);
            }
        }
    }
}
