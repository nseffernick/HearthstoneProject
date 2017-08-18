package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.Gnoll;
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

public class Hogger extends Minion {

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

    public Hogger(Player owner) {

        super(4, 4, 6, "Hogger", owner,"At the end of your turn, summon a 2/2 Gnoll with Taunt.", Rarity.LEGENDARY,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new HoggerText(this));
    }

    private class HoggerText extends Enchantments {

        private HoggerText(CanHaveEnchantments link) {
            super(Keywords.ENDOFYOURTURN, "Spawn Gnolls", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                minionLink.getOwner().summonMinion(new Gnoll(minionLink.getOwner()), board);
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {

        }
    }
}