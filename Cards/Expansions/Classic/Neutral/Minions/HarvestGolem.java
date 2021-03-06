package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.DamagedGolem;
import Game.CanHaveEnchantments;
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

public class HarvestGolem extends Minion {

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

    public HarvestGolem(Player owner) {

        super(3, 2, 3, "Harvest Golem", owner, "Deathrattle: Summon a 2/1 Damaged Golem.",
                Rarity.COMMON, Tribe.MECH, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new DeathrattleHarvestGolem(this));
    }

    private class DeathrattleHarvestGolem extends Enchantments {

        private DeathrattleHarvestGolem(CanHaveEnchantments link) {
            super(Keywords.DEATHRATTLE, "Summon Damaged Golem", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                minionLink.getOwner().summonMinion(new DamagedGolem(minionLink.getOwner()), board);
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {

        }
    }
}