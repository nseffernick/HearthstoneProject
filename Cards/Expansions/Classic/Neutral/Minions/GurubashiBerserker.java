package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class GurubashiBerserker extends Minion {

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

    public GurubashiBerserker(Player owner) {

        super(7, 2, 5, "Gurubashi Berserker", owner,
                "Whenever this minion takes damage, gain +3 Attack", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new GurubashiText(this));
    }

    public static class GurubashiText extends Enchantments {

        private int hits;

        public GurubashiText(CanHaveEnchantments link) {
            super(Keywords.ONHIT, "Gurubashi Attack Buff", link);
            hits = 0;
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                minionLink.addAtk(3);
                hits += 1;
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {
            minion.addAtk(-3*hits);
        }
    }
}
