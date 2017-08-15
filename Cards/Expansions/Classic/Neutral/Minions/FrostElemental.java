package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.Enchantments.Enchantments.HasFreeze;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import com.sun.xml.internal.bind.v2.TODO;

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
            playerTarget = owner.promptTargetPlayer(board);
            index = owner.promptTargetIndex(board, 0);
            if (Targeting.characterTargeting(playerTarget, index, true)) {
                break;
            }
        }
        if (index == -1) {
            //TODO Im a bad programmer
            playerTarget.getHero().getProperties().add(new HasFreeze());
        }
        else {
            playerTarget.getPlayerSide().get(index).getEnchantments().add(Keywords.FREEZE);
        }
    }
}
