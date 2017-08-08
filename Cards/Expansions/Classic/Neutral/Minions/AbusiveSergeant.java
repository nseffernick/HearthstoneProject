package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.TempBuffs.TempBuff;
import Utility.TempBuffs.TwoAttackBuff;
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

        super(1, 1, 1, "Abusive Sergeant", owner,"Battlecry: Give a minion +2 Attack this turn.",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (properties.contains(Keywords.BATTLECRY)) {
            int index = owner.promptTargetIndex(board, 3);
            if (index == 10);
            else if (Targeting.characterTargeting(owner, index, true)) {
                Minion minion = owner.getPlayerSide().get(index);
                TempBuff attackBuff = new TwoAttackBuff(minion);
                attackBuff.tempBuff(board);
            }
        }
    }
}
