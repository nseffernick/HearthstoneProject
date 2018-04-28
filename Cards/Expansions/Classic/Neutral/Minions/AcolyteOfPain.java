package Cards.Expansions.Classic.Neutral.Minions;

import Game.CanHaveEnchantments;
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

public class AcolyteOfPain extends Minion {

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

    public AcolyteOfPain(Player owner) {

        super(3, 1, 3, "Acolyte of Pain", owner,
                "Whenever this minion takes damage, draw a card", Rarity.COMMON,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new AcolyteText(this));
    }

    public static class AcolyteText extends Enchantments {

        private AcolyteText(CanHaveEnchantments link) {
            super(Keywords.ONHIT, "Acolyte Draw", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                minionLink.getOwner().drawCard();
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {

        }
    }
}