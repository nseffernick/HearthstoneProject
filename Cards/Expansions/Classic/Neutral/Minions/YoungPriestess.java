package Cards.Expansions.Classic.Neutral.Minions;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Text.HealthBuff;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class YoungPriestess extends Minion {

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

    public YoungPriestess(Player owner) {

        super(1, 2, 1, "Young Priestess", owner,"At the end of your turn, give another random friendly minion +1 Health.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new YoungPriestessText(this));
    }

    private class YoungPriestessText extends Enchantments {

        private YoungPriestessText(CanHaveEnchantments link) {
            super(Keywords.ENDOFYOURTURN, "Give +1 Health", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (owner.getPlayerSide().size() > 1) {
                int index = owner.getRng().randomNum(owner.getPlayerSide().size());
                while (!(owner.getPlayerSide().get(index) == link)) {
                    index = owner.getRng().randomNum(owner.getPlayerSide().size());
                }
                owner.getPlayerSide().get(index).getEnchantments().add(new HealthBuff(owner.getPlayerSide().get(index), 1));
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {

        }
    }
}