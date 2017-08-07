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

public class KnifeJuggler extends Minion {

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

    public KnifeJuggler(Player owner) {

        super(2, 2, 2, "Knife Juggler", owner,"Whenever you summon a minion, deal one damage to a random enemy character",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.MINIONSUMMONED);
    }

    @Override
    public void minionSummonedProc(Minion minion, BoardState board) {
        if (properties.contains(Keywords.MINIONSUMMONED)) {
            int index = owner.getRng().randomNum(UtilityMethods.findEnemy(board, owner).getPlayerSide().size()) - 1;
            Damaging.damageCharacter(UtilityMethods.findEnemy(board, owner), index, 1, board);
        }
    }
}