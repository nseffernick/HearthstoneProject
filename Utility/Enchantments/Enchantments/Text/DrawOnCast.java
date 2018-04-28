package Utility.Enchantments.Enchantments.Text;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class DrawOnCast extends Enchantments {

    public DrawOnCast(CanHaveEnchantments link) {
        super(Keywords.SPELLCASTED, "Draw When playing a spell", link);
    }

    @Override
    public void enchant(BoardState board, Minion minion, Spell spell) {
        if (link instanceof Minion) {
            Minion minionLink = (Minion) link;
            minionLink.getOwner().drawCard(board);
        }
    }

    @Override
    public void disenchant(BoardState board, Minion minion) {
    }
}