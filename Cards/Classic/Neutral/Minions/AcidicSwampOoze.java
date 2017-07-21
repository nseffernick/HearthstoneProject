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
    public int hp = 2;
    public int atk = 3;
    public int cost = 2;
    public String name = "Acidic Swamp Ooze";
    private String text = "Battlecry: Destroy the opponent's weapon";
    public Rarity rarity = Rarity.BASIC;
    public Tribe tribe = Tribe.GENERAL;
    public HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public AcidicSwampOoze(Player owner) {

        super(2, 3, 2, "Acidic Swamp Ooze", owner,
                "Battlecry: Destroy the opponent's weapon", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }


    @Override
    public void onDeath() {

    }

    @Override
    public void onSummon() {

    }

    @Override
    public void onTurnStart() {

    }

    /**
     * Destroy the opponent's weapon
     */
    public void battlecry(BoardState board) {
        if (properties.contains(Keywords.BATTLECRY)) {
            board.findEnemy(owner).getHero().setWeapon(null);
        }
    }
}