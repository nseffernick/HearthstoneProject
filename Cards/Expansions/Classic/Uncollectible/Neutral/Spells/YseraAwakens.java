package Cards.Expansions.Classic.Uncollectible.Neutral.Spells;

import Cards.Expansions.Classic.Neutral.Minions.Ysera;
import Cards.Structure.BenefitsFromSpellDamage;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

public class YseraAwakens extends Spell implements BenefitsFromSpellDamage {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;
    protected ArrayList<Enchantments> enchantments;

    public YseraAwakens(Player owner) {

        super(2, "Ysera Awakens", "Deal 5 damage to all characters except Ysera", owner,
                Rarity.BASIC, HeroClass.NEUTRAL);
    }

    @Override
    public void castSpell(BoardState board) {
        int spellDamage = calcSpellDamage(this);
        int dmg = 5 + spellDamage;
        damageAllButYseras(board, dmg);
    }

    private void damageAllButYseras(BoardState board, int dmg) {
        Damaging.damageCharacter(dmg, board.getP1().getHero());
        Damaging.damageCharacter(dmg, board.getP2().getHero());
        for (int i = 0; i < board.getP1().getPlayerSide().size(); i++) {
            if (board.getP1().getPlayerSide().get(i) instanceof Ysera);
            else Damaging.damageCharacter(dmg, board.getP1().getPlayerSide().get(i));
        }
        for (int x = 0; x < board.getP2().getPlayerSide().size(); x++) {
            if (board.getP2().getPlayerSide().get(x) instanceof Ysera);
            else Damaging.damageCharacter(dmg, board.getP2().getPlayerSide().get(x));
        }
    }
}
