package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.Gnoll;
import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Text.AttackBuff;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class MasterSwordsmith extends Minion {

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

    public MasterSwordsmith(Player owner) {

        super(3, 1, 2, "Master Swordsmith", owner,"At the end of your turn, give another random friendly minion +1 Attack.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new MasterSwordsmithText(this));
    }

    private class MasterSwordsmithText extends Enchantments {

        private MasterSwordsmithText(CanHaveEnchantments link) {
            super(Keywords.ENDOFYOURTURN, "Give +1 Attack", link);
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                if (!(owner.getPlayerSide().size() == 1)) {
                    int index = owner.getRng().randomNum(owner.getPlayerSide().size());
                    while (!(owner.getPlayerSide().get(index) == minionLink)) {
                        index = owner.getRng().randomNum(owner.getPlayerSide().size());
                    }
                    owner.getPlayerSide().get(index).getEnchantments().add(new AttackBuff(owner.getPlayerSide().get(index), 1));
                }
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {

        }
    }
}