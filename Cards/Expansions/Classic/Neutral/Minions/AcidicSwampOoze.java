package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

/**
 * Representation of the Acidic Swamp Ooze Minion
 */
public class AcidicSwampOoze extends Minion {

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

    public AcidicSwampOoze(Player owner) {

        super(2, 3, 2, "Acidic Swamp Ooze", owner,
                "Battlecry: Destroy the opponent's weapon", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    /**
     * Destroy the opponent's weapon
     */
    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (properties.contains(Keywords.BATTLECRY)) {
            UtilityMethods.findEnemy(board, owner).getHero().setWeapon(null);
        }
    }

    public static void main(String[] args) {

        BoardState board = new BoardState("Cards.Expansions.Classic.Neutral.Minions.AcidicSwampOoze",
                "Cards.Expansions.Classic.Neutral.Minions.AcidicSwampOoze", "Paladin", "Warlock", "e", "f");

        Minion ooze = new AcidicSwampOoze(board.getP1());
        AcidicSwampOoze ooze1 = new AcidicSwampOoze(board.getP1());

        System.out.println();
        System.out.println(ooze.getClass());
        System.out.println();

        System.out.println();
        System.out.println(ooze1.getClass().getName());
        System.out.println();

        //Class ooze1 = (Class) (ooze);
    }
}