package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Targeting.TargetType;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.Enchantments.Enchantments.Keywords.HasFreeze;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class FrostElemental extends Minion {

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

    public FrostElemental(Player owner) {

        super(5, 5, 6, "Frost Elemental", owner,
                "Battlecry: Freeze a character", Rarity.COMMON,
                Tribe.ELEMENTAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        Player playerTarget = null;
        int index = -2;
        while (1 == 1) {
            playerTarget = owner.promptTargetPlayer(board, TargetType.ANY);
            index = owner.promptTargetIndex(board, playerTarget);
            if (Targeting.characterTargeting(, playerTarget, true)) {
                break;
            }
        }
        if (index == -1) {
            //TODO Im a bad programmer
            playerTarget.getHero().getEnchantments().add(new HasFreeze(playerTarget.getHero()));
        }
        else {
            playerTarget.getPlayerSide().get(index).getEnchantments().add(new HasFreeze(playerTarget.getPlayerSide().get(index)));
        }
    }
}
