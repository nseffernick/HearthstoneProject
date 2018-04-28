package Utility.Enchantments.Structure;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;

public abstract class Enchantments {

    protected Keywords keyword;
    protected String name;
    protected CanHaveEnchantments link;

    public Enchantments(Keywords keyword, String name, CanHaveEnchantments link) {
        this.keyword = keyword;
        this.name = name;
        this.link = link;
    }

    public Keywords getKeyword() { return keyword; }

    public String getName() { return name; }

    public abstract void enchant(BoardState board, Minion minion, Spell spell);

    public abstract void disenchant(BoardState board, Minion minion);

    protected void damageToAllMinions(BoardState board, int dmg) {
        for (int i = 0; i < board.getP1().getPlayerSide().size(); i++) {
            Damaging.damageCharacter(board.getP1(), i, dmg, board);
        }
        for (int x = 0; x < board.getP2().getPlayerSide().size(); x++) {
            Damaging.damageCharacter(board.getP2(), x, dmg, board);
        }
    }

    protected void damageAllCharacters(BoardState board, int dmg) {
        Damaging.damageCharacter(board.getP1(), -1, -dmg, board);
        Damaging.damageCharacter(board.getP2(), -1, -dmg, board);
        damageToAllMinions(board, dmg);
    }

    protected void damageAllCharactersExceptThis(BoardState board, int dmg, Minion thisMinion) {
        Damaging.damageCharacter(board.getP1(), -1, dmg, board);
        Damaging.damageCharacter(board.getP2(), -1, dmg, board);
        for (int i = 0; i < board.getP1().getPlayerSide().size(); i++) {
            if (board.getP1().getPlayerSide().get(i) == thisMinion);
            else Damaging.damageCharacter(board.getP1(), i, dmg, board);
        }
        for (int x = 0; x < board.getP2().getPlayerSide().size(); x++) {
            if (board.getP2().getPlayerSide().get(x) == thisMinion);
            else Damaging.damageCharacter(board.getP2(), x, dmg, board);
        }
    }

    protected boolean checkForKeyword(Keywords keyword, Minion minion) {
        for (Enchantments enchantments: minion.getEnchantments()) {
            if (enchantments.getKeyword() == keyword) {
                return true;
            }
        }
        return false;
    }

    protected void attackHealthBuff(Minion minionLink, int set) {
        minionLink.addMaxHP(set);
        minionLink.addAtk(set);
    }

}
