package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Secret;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Secretkeeper extends Minion {

    // State
    protected int hp;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Enchantments> enchantments;

    public Secretkeeper(Player owner) {

        super(2, 1, 1, "Secretkeeper", owner,"Whenever a Secret is played, gain +1/+1.", Rarity.RARE,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void spellCastedProc(Spell spell, BoardState board) {
        if (spell.getEnchantments().contains(Keywords.SECRET)) {
            addAtk(1);
            addMaxHP(1);
            addHp(1, board);
        }
    }

    private class QuestingText extends Enchantments {

        private int secrets;

        private QuestingText(CanHaveEnchantments link) {
            super(Keywords.SPELLCASTED, "Quest to improve stats", link);
            secrets = 0;
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                if (spell instanceof Secret) {
                    Minion minionLink = (Minion) link;
                    addAtk(1);
                    addMaxHP(1);
                    secrets += 1;
                }
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                addAtk(-secrets);
                addMaxHP(-secrets);
            }
        }
    }
}