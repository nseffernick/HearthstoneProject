package Utility.Enchantments.Enchantments;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class DreadCorsairDiscount extends Enchantments {

    public DreadCorsairDiscount(Minion link) {
        super(Keywords.WEAPONSTATE, "Discount Dread Corsair", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        if (link.getOwner().getHero().getWeapon() != null) {
            int discount = link.getOwner().getHero().getWeapon().getAtk();
            int newCost = 4 - discount;
            link.setCost(newCost);
        }
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}