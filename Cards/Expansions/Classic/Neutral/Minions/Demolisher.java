package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class Demolisher extends Minion {

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

    public Demolisher(Player owner) {

        super(4, 1, 3, "Demolisher", owner,"At the start of your turn, deal 2 damage to a random enemy.",
                Rarity.RARE, Tribe.MECH, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.STARTOFYOURTURN);
    }

    @Override
    public void startOfYourTurn(BoardState board) {
        if (properties.contains(Keywords.STARTOFYOURTURN)) {
            int index = owner.getRng().randomNum(UtilityMethods.findEnemy(board, owner).getPlayerSide().size()) - 1;
            Damaging.damageCharacter(UtilityMethods.findEnemy(board, owner), index, 2, board);
        }
    }
}