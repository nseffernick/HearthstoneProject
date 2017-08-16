package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Doomsayer extends Minion {

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

    public Doomsayer(Player owner) {

        super(4, 1, 3, "Demolisher", owner,"At the start of your turn, destroy all minions.",
                Rarity.EPIC, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new DoomIsNear(this));
    }

    public static class DoomIsNear extends Enchantments {

        public DoomIsNear(CanHaveEnchantments link) {
            super(Keywords.STARTOFYOURTURN, "Kill all minions", link);
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            for (Minion minion1: board.getP1().getPlayerSide()) {
                minion1.destroy(board);
            }
            for (Minion minion1: board.getP2().getPlayerSide()) {
                minion1.destroy(board);
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {
        }
    }
}