package Cards.Expansions.Classic.Uncollectible.Neutral.Spells;

import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Text.AttackHealthBuff;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

public class Banana extends Spell {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;

    public Banana(Player owner) {

        super(1, "Banana", "Give a minion +1/+1", owner,
                Rarity.BASIC, HeroClass.NEUTRAL);
    }

    @Override
    public void castSpell(BoardState board) {
        Player player = owner.promptTargetPlayer(board);
        int index = owner.promptTargetIndex(board, 2);
        if (index == 10);
        else {
            Minion minion = player.getPlayerSide().get(index);
            minion.getEnchantments().add(new AttackHealthBuff(minion, 1, 1));
        }
    }
}