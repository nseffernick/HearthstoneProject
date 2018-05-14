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
            Damaging.damageCharacter(dmg, board.getP1().getPlayerSide().get(i));
        }
        for (int x = 0; x < board.getP2().getPlayerSide().size(); x++) {
            Damaging.damageCharacter(dmg, board.getP2().getPlayerSide().get(x));
        }
    }

    protected void damageAllCharacters(BoardState board, int dmg) {
        Damaging.damageCharacter(-dmg, board.getP1().getHero());
        Damaging.damageCharacter(-dmg, board.getP2().getHero());
        damageToAllMinions(board, dmg);
    }

    protected void damageAllCharactersExceptThis(BoardState board, int dmg, Minion thisMinion) {
        Damaging.damageCharacter(dmg, board.getP1().getHero());
        Damaging.damageCharacter(dmg, board.getP1().getHero());
        for (int i = 0; i < board.getP1().getPlayerSide().size(); i++) {
            if (board.getP1().getPlayerSide().get(i) == thisMinion);
            else Damaging.damageCharacter(dmg, board.getP1().getPlayerSide().get(i));
        }
        for (int x = 0; x < board.getP2().getPlayerSide().size(); x++) {
            if (board.getP2().getPlayerSide().get(x) == thisMinion);
            else Damaging.damageCharacter(dmg, board.getP2().getPlayerSide().get(x));
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
