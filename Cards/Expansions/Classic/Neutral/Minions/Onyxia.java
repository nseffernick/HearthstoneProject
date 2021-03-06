package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.Whelp;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Onyxia extends Minion {

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

    public Onyxia(Player owner) {

        super(8, 8, 9, "Onyxia", owner,
                "Battlecry: Summon 1/1 Whelps until your side of the battlefield is full.", Rarity.LEGENDARY,
                Tribe.DRAGON, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    public void battlecry(BoardState board, Player player, int index) {
        if (owner.getPlayerSide().size() < 7) {
            owner.summonMinion(new Whelp(owner), board);
        }
    }
}