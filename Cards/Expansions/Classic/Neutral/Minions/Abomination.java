package Cards.Expansions.Classic.Neutral.Minions;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Abomination extends Minion {

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

    public Abomination(Player owner) {

        super(4, 4, 5, "Abomination", owner,"Taunt. Deathrattle: Deal 2 damage to ALL characters.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new AbominationDeathrattle(this));
        enchantments.add(new HasTaunt(this));
    }

    public static class AbominationDeathrattle extends Enchantments {

        public AbominationDeathrattle(CanHaveEnchantments link) {
            super(Keywords.DEATHRATTLE, "Abomination Deathrattle", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            damageAllCharacters(board, 2);
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {

        }
    }
}
