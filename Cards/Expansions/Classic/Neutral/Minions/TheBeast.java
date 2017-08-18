package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.FinkleEinhorn;
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
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class TheBeast extends Minion {

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

    public TheBeast(Player owner) {

        super(7, 9, 6, "The Beast", owner, "Deathrattle: Summon a 3/3 Finkle Einhorn for your opponent.",
                Rarity.LEGENDARY, Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new DeathrattleTheBeast(this));
    }

    private class DeathrattleTheBeast extends Enchantments {

        private DeathrattleTheBeast(CanHaveEnchantments link) {
            super(Keywords.DEATHRATTLE, "Summon Finkle", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
                UtilityMethods.findEnemy(board, owner).summonMinion(new FinkleEinhorn(UtilityMethods.findEnemy(board, owner)), board);
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {

        }
    }
}