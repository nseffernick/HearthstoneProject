package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Targeting.TargetType;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

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
    protected ArrayList<Enchantments> enchantments;

    public TheBlackKnight(Player owner) {

        super(5, 4, 6, "The Black Knight", owner,
                "Battlecry: Destroy an enemy minion with taunt.", Rarity.LEGENDARY,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        boolean canTarget = false;
        for (int i = 0; i < this.getOwner().getPlayerSide().size(); i++) {
            if (this.getOwner().getPlayerSide().get(i).getEnchantments().contains(new HasTaunt(null)) &&
                    Targeting.characterTargeting(this, true)) {
                chooseMinionToDestroy(board);
            }
        }

    }

    private void chooseMinionToDestroy(BoardState board) {
        Minion minion;
        while (1 == 1) {
            minion = getOwner().promptAMinion(board, TargetType.ANY);
            if (minion.getEnchantments().contains(new HasTaunt(null)) &&
                    Targeting.characterTargeting(minion, true)) {
                minion.destroy();
                break;
            }
            System.out.println("Invalid minion, please choose another.\n");
        }
    }
}
