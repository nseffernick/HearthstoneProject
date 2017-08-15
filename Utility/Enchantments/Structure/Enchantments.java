package Utility.Enchantments.Structure;

import Cards.Structure.Minion;
import Game.BoardState;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;

public abstract class Enchantments {

    protected Keywords keyword;
    protected String name;
    protected Minion link;

    public Enchantments(Keywords keyword, String name, Minion link) {
        this.keyword = keyword;
        this.name = name;
        this.link = link;
    }

    public Keywords getKeyword() { return keyword; }

    public String getName() { return name; }

    protected abstract void enchant(BoardState board, Minion minion);

    protected abstract void disenchant(BoardState board, Minion minion);

    protected void damageAllCharacters(BoardState board, int dmg) {
        Damaging.damageCharacter(board.getP1(), -1, -dmg, board);
        Damaging.damageCharacter(board.getP2(), -1, -dmg, board);
        for (int i = 0; i < board.getP1().getPlayerSide().size(); i++) {
            Damaging.damageCharacter(board.getP1(), i, dmg, board);
        }
        for (int x = 0; x < board.getP2().getPlayerSide().size(); x++) {
            Damaging.damageCharacter(board.getP2(), x, dmg, board);
        }
    }

    protected void damageAllCharactersExceptThis(BoardState board, int dmg, Minion thisMinion) {
        Damaging.damageCharacter(board.getP1(), -1, -dmg, board);
        Damaging.damageCharacter(board.getP2(), -1, -dmg, board);
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

}
