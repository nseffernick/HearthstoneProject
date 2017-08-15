package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.SpellDamage1;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class AncientMage extends Minion {

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

    public AncientMage(Player owner) {

        super(5, 2, 4, "Ancient Mage", owner, "Battlecry: Give adjacent minions Spell Damage +1.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        Minion left = null;
        if (position == 0);
        else {
            left = owner.getPlayerSide().get(position - 1);
        }
        Minion right = null;
        if (position == owner.getPlayerSide().size());
        else {
            right = owner.getPlayerSide().get(position);
        }
        if (left != null) {
            left.getEnchantments().add(new SpellDamage1(left));
        }
        if (right != null) {
            right.getEnchantments().add(new SpellDamage1(right));
        }
    }
}
