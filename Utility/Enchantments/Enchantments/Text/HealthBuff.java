package Utility.Enchantments.Enchantments.Text;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;

public class HealthBuff extends Enchantments {

    private int health;

    public HealthBuff(CanHaveEnchantments link, int health) {
        super(null, "Attack Buff", link);
        this.health = health;
        enchant(null, null, null);
    }

    @Override
    public void enchant(BoardState board, Minion minion, Spell spell) {
        if (link instanceof Minion) {
            Minion minionLink = (Minion) link;
            minionLink.addMaxHP(health);
        }
    }

    @Override
    public void disenchant(BoardState board, Minion minion) {
        if (link instanceof Minion) {
            Minion minionLink = (Minion) link;
            minionLink.addMaxHP(-health);
        }
    }
}