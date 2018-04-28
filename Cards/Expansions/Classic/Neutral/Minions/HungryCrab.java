package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class HungryCrab extends Minion {

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

    public HungryCrab(Player owner) {

        super(2, 1, 1, "Hungry Crab", owner,"Battlecry: Destroy a Murloc and gain +2/+2.",
                Rarity.EPIC, Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        boolean canTarget = false;
        for (Minion minion: UtilityMethods.findEnemy(board, owner).getPlayerSide()) {
            if (minion.getTribe() == Tribe.MURLOC) {
                canTarget = true;
            }
        }
        for (Minion minion: owner.getPlayerSide()) {
            if (minion.getTribe() == Tribe.MURLOC) {
                canTarget = true;
            }
        }
        if (canTarget) {
            destroyMurloc(board);
        }
    }

    private void destroyMurloc(BoardState board) {
        while(1 == 1) {
            try {
                Player targetPlayer = owner.promptTargetPlayer(board, );
                int index = owner.promptTargetIndex(board, ) - 1;
                if (targetPlayer.getPlayerSide().get(index).getTribe() == Tribe.MURLOC) {
                    targetPlayer.getPlayerSide().get(index).destroy(board);
                    addAtk(2);
                    addMaxHP(2);
                    addHp(board, 2, );
                    break;
                }
                else {
                    System.out.println("Please pick a Murloc to destroy");
                }
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid Index, Most likely issue: Size needs to be greater than index.");
                System.out.println(e.getMessage());
            }
        }
    }
}