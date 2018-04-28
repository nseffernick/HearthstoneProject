package Cards.Expansions.Classic.Neutral.Minions;

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

public class NatPagle extends Minion {

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

    public NatPagle(Player owner) {

        super(4, 0, 2, "Nat Pagle", owner,"At the start of your turn, you have a 50% chance to draw an extra card.",
                Rarity.LEGENDARY, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new NatPagleText(this));
    }

    private class NatPagleText extends Enchantments {

        private NatPagleText(CanHaveEnchantments link) {
            super(Keywords.STARTOFYOURTURN, "Maybe Draw a Card", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                boolean maybeDraw = owner.getRng().randomBool();
                if (maybeDraw) { owner.drawCard(); }
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {

        }
    }
}