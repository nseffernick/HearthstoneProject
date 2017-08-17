package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class DreadCorsair extends Minion {

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

    public DreadCorsair(Player owner) {

        super(3, 3, 4, "Dread Corsair", owner,"Taunt Costs one less for each attack on your weapon",
                Rarity.COMMON, Tribe.PIRATE, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new HasTaunt(this));
        enchantments.add(new DreadCorsairDiscount(this));
    }

    private class DreadCorsairDiscount extends Enchantments {

        private DreadCorsairDiscount(CanHaveEnchantments link) {
            super(Keywords.WEAPONSTATE, "Discount Dread Corsair", link);
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                if (minionLink.getOwner().getHero().getWeapon() != null) {
                    int discount = minionLink.getOwner().getHero().getWeapon().getAtk();
                    int newCost = 4 - discount;
                    minionLink.setCost(newCost);
                }
            }
            else {
                System.out.println(name + " Enchantment failed.");
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {
        }
    }
}