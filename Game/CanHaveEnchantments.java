package Game;

import Utility.Enchantments.Enchantments.Keywords.HasWindfury;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

import java.util.ArrayList;

public interface CanHaveEnchantments {

    ArrayList<Enchantments> getEnchantments();

    default boolean checkForKeyword(Keywords keyword, ArrayList<Enchantments> enchantmentsList) {
        for (Enchantments enchantments: enchantmentsList) {
            if (enchantments.getKeyword() == keyword) {
                return true;
            }
        }
        return false;
    }

    default boolean checkForEnchantment(Enchantments enchantmentType, ArrayList<Enchantments> enchantmentsList) {
        for (Enchantments ench: enchantmentsList) {
            if (ench.getClass().isInstance(enchantmentType)) {
                return true;
            }
        }
        return false;
    }
}

