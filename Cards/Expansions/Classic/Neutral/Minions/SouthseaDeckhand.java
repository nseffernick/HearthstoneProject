package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.Gnoll;
import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Cards.Structure.Weapon;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasCharge;
import Utility.Enchantments.Enchantments.Keywords.HasWindfury;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class SouthseaDeckhand extends Minion {

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

    public SouthseaDeckhand(Player owner) {

        super(1, 2, 1, "Southsea Deckhand", owner,"Has Charge while you have a weapon equipped.",
                Rarity.COMMON, Tribe.PIRATE, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void weaponPlayedProc(Weapon weapon, BoardState board) {

    }

    private class HoggerText extends Enchantments {

        private HoggerText(CanHaveEnchantments link) {
            super(Keywords.WEAPONPLAYED, "Spawn Gnolls", link);
            enchant(null, null, null);
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            boolean hasCharge = false;
            if (owner.getHero().getWeapon() != null) {
                addCharge(hasCharge);
            }
            else {
                removeCharge(hasCharge);
            }
        }

        private void addCharge(boolean hasCharge) {
            for (Enchantments ench : enchantments) {
                if (ench instanceof HasCharge) {
                    hasCharge = true;
                    break;
                }
            }
            if (!hasCharge)
            enchantments.add(new HasCharge(link));
        }

        private void removeCharge(boolean hasCharge) {
            for (Enchantments ench : enchantments) {
                if (ench instanceof HasCharge) {
                    hasCharge = true;
                    enchantments.remove(ench);
                }
            }
            if (hasCharge)
                enchantments.add(new HasCharge(link));
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {

        }
    }
}