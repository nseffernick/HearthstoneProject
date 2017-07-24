package Cards.Classic.Neutral.Minions;

import Cards.Classic.Uncollectible.Tokens.MechanicalDragonling;
import Cards.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Dragonling Mechanic Minion
 */
public class DragonlingMechanic extends Minion {

    // State
    public int hp = 4;
    public int atk = 2;
    public int cost = 4;
    public String name = "Dragonling Mechanic";
    private String text = "Battlecry: Summon a 2/1 Mechanical Dragonling";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.GENERAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public DragonlingMechanic(Player owner) {

        super(4, 2, 4, "Dragonling Mechanic", owner,
                "Battlecry: Summon a 2/1 Mechanical Dragonling", Rarity.BASIC,
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

    // Summon a 2/1 dragonling
    public void battlecry(BoardState board, Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            owner.summonCard(new MechanicalDragonling(owner));
        }
    }
}