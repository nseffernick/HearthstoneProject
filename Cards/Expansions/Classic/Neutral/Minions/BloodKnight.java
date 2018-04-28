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

public class BloodKnight extends Minion {

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



    public BloodKnight(Player owner) {

        super(3, 3, 3, "Blood Knight", owner, "Battlecry: Remove all minion's Divine Shield " +
                        "and gain +3/+3 for each Divine Shield removed.", Rarity.EPIC, Tribe.GENERAL, HeroClass.NEUTRAL,
                new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        int numShieldsPopped = 0;
        for (Minion minion: owner.getPlayerSide()) {
            if (minion.getEnchantments().contains(Keywords.DIVINESHIELD)) {
                minion.getEnchantments().remove(Keywords.DIVINESHIELD);
                numShieldsPopped += 1;
            }
        }
        for (Minion minion: UtilityMethods.findEnemy(board, owner).getPlayerSide()) {
            if (minion.getEnchantments().contains(Keywords.DIVINESHIELD)) {
                minion.getEnchantments().remove(Keywords.DIVINESHIELD);
                numShieldsPopped += 1;
            }
        }
        addAtk(3 * numShieldsPopped);
        addMaxHP(3 * numShieldsPopped);
        addHp(board, 3 * numShieldsPopped, );
    }
}