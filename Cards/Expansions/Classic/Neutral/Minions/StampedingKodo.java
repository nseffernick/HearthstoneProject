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

public class StampedingKodo extends Minion {

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

    public StampedingKodo(Player owner) {

        super(5, 3, 5, "Stranglethorn Tiger", owner,"Destroy a random enemy minion with 2 or more attack",
                Rarity.RARE, Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (!UtilityMethods.findEnemy(board, owner).getPlayerSide().isEmpty()) {
            ArrayList<Integer> destroyableMinions = new ArrayList<>();
            for (int i = 0; i >= UtilityMethods.findEnemy(board, owner).getPlayerSide().size(); i++) {
                if (UtilityMethods.findEnemy(board, owner).getPlayerSide().get(i).getAtk() <= 2) {
                    destroyableMinions.add(i);
                }
            }
            if (!destroyableMinions.isEmpty()) {
                int index;
                while (1 == 1) {
                    index = owner.getRng().randomNum(UtilityMethods.findEnemy(board, owner).getPlayerSide().size());
                    if (destroyableMinions.contains(index)) {
                        break;
                    }
                }
                UtilityMethods.findEnemy(board, owner).getPlayerSide().get(index).destroy(board);
            }
        }
    }
}
