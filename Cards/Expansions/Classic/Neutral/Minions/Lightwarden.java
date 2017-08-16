package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Lightwarden extends Minion {

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

    public Lightwarden(Player owner) {

        super(2, 1, 1, "Lightwarden", owner,"Whenever a character is healed, gain +2 Attack.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new LightwardenText(this));
    }

    @Override
    public void healProc() {
        addAtk(2);
    }

    private class LightwardenText extends Enchantments {

        private int heals;

        private LightwardenText(CanHaveEnchantments link) {
            super(Keywords.HEALPROC, "Gain attack on heal", link);
            heals = 0;
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                minionLink.addAtk(2);
                heals += 1;
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                minionLink.addAtk(-2*heals);
            }
        }
    }
}