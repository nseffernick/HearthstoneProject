package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class MadBomber extends Minion {

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

    public MadBomber(Player owner) {

        super(2, 3, 2, "Mad Bomber", owner,"Deal 1 damage randomly split between all other characters",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        int numBombs = 3;
        while (numBombs != 0) {
            int numTargets = owner.getPlayerSide().size() + owner.getPlayerSide().size() + 2;
            int index = owner.getRng().randomNum(numTargets) - 2;
            if (index == -2) {
                Damaging.damageCharacter(UtilityMethods.findEnemy(board, player), -1, 1, board);
            }
            else if (index == -1) {
                Damaging.damageCharacter(owner, -1, 1, board);
            }
            else if (index < UtilityMethods.findEnemy(board, player).getPlayerSide().size()) {
                Damaging.damageCharacter(UtilityMethods.findEnemy(board, player), index, 1, board);
            }
            else {
                index -= UtilityMethods.findEnemy(board, player).getPlayerSide().size();
                Damaging.damageCharacter(owner, index, 1, board);
            }
            numBombs -= 1;
            owner.checkBoardForDead(board);
            UtilityMethods.findEnemy(board, player).checkBoardForDead(board);
        }
    }
}
