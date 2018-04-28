package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class BigGameHunter extends Minion {

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

    public BigGameHunter(Player owner) {

        super(2, 4, 5, "Big Game Hunter", owner,
                "Battlecry: Destroy a minion with 7 or more attack", Rarity.EPIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {

        boolean canTargetFriend = false;
        boolean canTargetEnemy = false;
        for (Minion minion : owner.getPlayerSide()) {
            if (minion.getAtk() >= 7 && !minion.getEnchantments().contains(Keywords.STEALTH)) {
                canTargetFriend = true;
            }
        }
        for (Minion minion : UtilityMethods.findEnemy(board, owner).getPlayerSide()) {
            if (minion.getAtk() >= 7 && !minion.getEnchantments().contains(Keywords.STEALTH)) {
                canTargetEnemy = true;
            }
        }
        Player targetPlayer = null;
        if (canTargetFriend && canTargetEnemy) {
            targetPlayer = owner.promptTargetPlayer(board, );
        }
        else if (canTargetFriend) {
            targetPlayer = owner;
        }
        else if (canTargetEnemy) {
            targetPlayer = UtilityMethods.findEnemy(board, owner);
        }
        chooseMinionToDestroy(board, targetPlayer);

    }

    private void chooseMinionToDestroy(BoardState board, Player targetPlayer) {
        if (targetPlayer != null) {
            Minion minion;
            while (1 == 1) {
                int index = owner.promptTargetIndex(board, );
                minion = targetPlayer.getPlayerSide().get(index);
                if (minion.getAtk() >= 7) {
                    if (targetPlayer != owner && !minion.getEnchantments().contains(Keywords.STEALTH)) break;
                    if (targetPlayer == owner) break;
                }
                System.out.println("Invalid minion, please choose another.\n");
            }
            minion.destroy(board);
        }
    }
}
