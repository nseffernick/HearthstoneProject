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

public class MindControlTech extends Minion {

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

    public MindControlTech(Player owner) {

        super(3, 3, 3, "Mind Control Tech", owner,"If your opponent has 4 or more minions, steal one.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (UtilityMethods.findEnemy(board, owner).getPlayerSide().size() >= 4) {
            int index = owner.getRng().randomNum(UtilityMethods.findEnemy(board, owner).getPlayerSide().size());
            Minion minion = UtilityMethods.findEnemy(board, owner).getPlayerSide().get(index);
            UtilityMethods.findEnemy(board, owner).getPlayerSide().remove(minion);
            owner.getPlayerSide().add(minion);
        }
    }
}
