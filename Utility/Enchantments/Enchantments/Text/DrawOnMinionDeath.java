package Utility.Enchantments.Enchantments.Text;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class DrawOnMinionDeath extends Enchantments {

    public DrawOnMinionDeath(CanHaveEnchantments link) {
        super(Keywords.MINIONDEATH, "Draw on Minion Death", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion, Spell spell) {
        if (link instanceof Minion) {
            Minion minionLink = (Minion) link;
            if (minion.getOwner() == minionLink.getOwner()) {
                minionLink.getOwner().drawCard();
            }
        }
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}