package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.Imp;
import Game.CanHaveEnchantments;
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

// I am not a morning person
public class ImpMaster extends Minion {

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

    public ImpMaster(Player owner) {

        super(5, 1, 3, "Imp Master", owner,"At the end of your turn, deal 1 damage to this minion and summon a 1/1 Imp.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new ImpMasterText(this));
    }

    public static class ImpMasterText extends Enchantments {

        public ImpMasterText(CanHaveEnchantments link) {
            super(Keywords.ENDOFYOURTURN, "Spawn Imps", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                minionLink.getOwner().summonMinion(new Imp(minionLink.getOwner()), board);
                minionLink.addHp(-1, board);
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {

        }
    }
}