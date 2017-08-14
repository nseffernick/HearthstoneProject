package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class TheBlackKnight extends Minion {

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

    public TheBlackKnight(Player owner) {

        super(5, 4, 6, "The Black Knight", owner,
                "Battlecry: Destroy an enemy minion with taunt.", Rarity.LEGENDARY,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (properties.contains(Keywords.BATTLECRY)) {
            boolean canTargetEnemy = false;
            for (Minion minion : UtilityMethods.findEnemy(board, owner).getPlayerSide()) {
                if (minion.getEnchantments().contains(Keywords.TAUNT) && !minion.getEnchantments().contains(Keywords.STEALTH)) {
                    canTargetEnemy = true;
                }
            }
            Player targetPlayer = null;
            if (canTargetEnemy) {
                targetPlayer = UtilityMethods.findEnemy(board, owner);
            }
            chooseMinionToDestroy(board, targetPlayer);
        }
    }

    private void chooseMinionToDestroy(BoardState board, Player targetPlayer) {
        if (targetPlayer != null) {
            Minion minion;
            while (1 == 1) {
                int index = owner.promptTargetIndex(board, 0);
                minion = targetPlayer.getPlayerSide().get(index);
                if (minion.getEnchantments().contains(Keywords.TAUNT) && !minion.getEnchantments().contains(Keywords.STEALTH)) {
                    break;
                }
                System.out.println("Invalid minion, please choose another.\n");
            }
            minion.destroy(board);
        }
    }
}
