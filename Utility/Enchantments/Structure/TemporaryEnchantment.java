package Utility.Enchantments.Structure;

import Cards.Structure.Minion;
import Game.BoardState;

public interface TemporaryEnchantment {

    public void temporaryDisenchant(BoardState board, Minion minion);
}
