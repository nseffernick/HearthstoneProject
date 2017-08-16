package Utility.Enchantments.Enchantments.Text;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class DeathrattleDraw extends Enchantments {

    public DeathrattleDraw(CanHaveEnchantments link) {
        super(Keywords.DEATHRATTLE, "Deathrattle: Draw a Card", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion, Spell spell) {
        if (link instanceof Minion) {
            Minion minionLink = (Minion) link;
            minionLink.getOwner().drawCard();
        }
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}