package Utility.Enchantments.Enchantments.Text;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;

public class AttackHealthBuff extends Enchantments {

    private int health;
    private int attack;

    public AttackHealthBuff(CanHaveEnchantments link, int attack) {
        super(null, "Attack Buff", link);
        this.attack = attack;
        enchant(null, null, null);
    }

    @Override
    protected void enchant(BoardState board, Minion minion, Spell spell) {
        if (link instanceof Minion) {
            Minion minionLink = (Minion) link;
            minionLink.addAtk(attack);
            minionLink.addMaxHP(health);
        }
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
        if (link instanceof Minion) {
            Minion minionLink = (Minion) link;
            minionLink.addAtk(-attack);
            minionLink.addMaxHP(-health);
        }
    }
}
