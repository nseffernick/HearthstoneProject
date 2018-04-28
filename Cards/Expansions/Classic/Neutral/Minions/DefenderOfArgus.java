package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Enchantments.Text.AttackHealthBuff;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class DefenderOfArgus extends Minion {

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

    public DefenderOfArgus(Player owner) {

        super(3, 2, 4, "Defender of Argus", owner, "Battlecry: Give adjacent minions taunt and +1/+1",
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
            left.getEnchantments().add(new HasTaunt(left));
            left.getEnchantments().add(new AttackHealthBuff(left, 1, 1));
        }
        if (right != null) {
            right.getEnchantments().add(new HasTaunt(right));
            right.getEnchantments().add(new AttackHealthBuff(right, 1, 1));
        }
    }
}