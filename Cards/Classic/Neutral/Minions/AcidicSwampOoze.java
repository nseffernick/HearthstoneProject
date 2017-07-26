package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Acidic Swamp Ooze Minion
 */
public class AcidicSwampOoze extends Minion {

    // State
    protected int hp = 2;
    protected int atk = 3;
    protected int cost = 2;
    protected String name = "Acidic Swamp Ooze";
    protected String text = "Battlecry: Destroy the opponent's weapon";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public AcidicSwampOoze(Player owner) {

        super(2, 3, 2, "Acidic Swamp Ooze", owner,
                "Battlecry: Destroy the opponent's weapon", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    /**
     * Destroy the opponent's weapon
     */
    public void battlecry(BoardState board, Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            board.findEnemy(owner).getHero().setWeapon(null);
        }
    }

    public static void main(String[] args) {

        BoardState board = new BoardState("Cards.Classic.Neutral.Minions.AcidicSwampOoze",
                "Cards.Classic.Neutral.Minions.AcidicSwampOoze", "Paladin", "Warlock", "e", "f");

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