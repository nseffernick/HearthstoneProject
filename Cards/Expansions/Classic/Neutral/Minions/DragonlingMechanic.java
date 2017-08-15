package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.MechanicalDragonling;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Enchantments.Structure.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Dragonling Mechanic Minion
 */
public class DragonlingMechanic extends Minion {

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


    public DragonlingMechanic(Player owner) {

        super(4, 2, 4, "Dragonling Mechanic", owner,
                "Battlecry: Summon a 2/1 Mechanical Dragonling", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    // Summon a 2/1 dragonling
    public void battlecry(BoardState board, Player player, int index) {
        owner.summonMinion(new MechanicalDragonling(owner), board);
    }
}