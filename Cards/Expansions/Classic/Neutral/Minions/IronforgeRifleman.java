package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Game.Targetable;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.AttackAndTargetBehaviors.Targeting.TargetType;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class IronforgeRifleman extends Minion {

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

    public IronforgeRifleman(Player owner) {

        super(2, 2, 3, "Ironforge Rifleman", owner,
                "Battlecry: Deal one damage", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    // Deal one damage
    @Override
    public void battlecry(BoardState board, Player player, int position) {
        Targetable target;
        while (1==1) {
            target = getOwner().promptATarget(board, TargetType.ANY);
            if (Targeting.characterTargeting(target, true)) {
                Damaging.damageCharacter(1, target);
            }
        }
    }
}
