package Utility.Enchantments.Enchantments.Text;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;

public class AttackBuff extends Enchantments {

    private int attack;

    public AttackBuff(CanHaveEnchantments link, int attack) {
        super(null, "Attack Buff", link);
        this.attack = attack;
        enchant(null, null, null);
    }

    @Override
    public void enchant(BoardState board, Minion minion, Spell spell) {
        if (link instanceof Minion) {
            Minion minionLink = (Minion) link;
            minionLink.addAtk(attack);
        }
    }

    @Override
    public void disenchant(BoardState board, Minion minion) {
        if (link instanceof Minion) {
            Minion minionLink = (Minion) link;
            minionLink.addAtk(-attack);
        }
    }
}