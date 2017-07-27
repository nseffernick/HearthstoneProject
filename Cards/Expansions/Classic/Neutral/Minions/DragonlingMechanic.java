package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Tokens.MechanicalDragonling;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
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
    protected int hp = 4;
    protected int atk = 2;
    protected int cost = 4;
    protected String name = "Dragonling Mechanic";
    protected String text = "Battlecry: Summon a 2/1 Mechanical Dragonling";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public DragonlingMechanic(Player owner) {

        super(4, 2, 4, "Dragonling Mechanic", owner,
                "Battlecry: Summon a 2/1 Mechanical Dragonling", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    // Summon a 2/1 dragonling
    public void battlecry(BoardState board, Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            owner.summonCard(new MechanicalDragonling(owner));
        }
    }
}