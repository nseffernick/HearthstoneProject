package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class EarthenRingFarseer extends Minion {

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

    public EarthenRingFarseer(Player owner) {

        super(3, 3, 3, "Earthen Ring Farseer", owner, "Battlecry: Restore 3 health",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        Player targetPlayer;
        int index;
        while (1 == 1) {
            targetPlayer = owner.promptTargetPlayer(board, );
            index = owner.promptTargetIndex(board, );
            if (Targeting.characterTargeting(, targetPlayer, true)) {
                break;
            }
        }
        Damaging.damageCharacter(-3, , board);
    }
}