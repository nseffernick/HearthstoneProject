package Cards.Expansions.Classic.Uncollectible.Neutral.Spells;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Text.AttackHealthBuff;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;

public class Nightmare extends Spell {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;

    public Nightmare(Player owner) {

        super(0, "Nightmare", "Give a minion +5/+5; This minion dies at the start of the owner's next turn", owner,
                Rarity.BASIC, HeroClass.NEUTRAL);
    }

    @Override
    public void castSpell(BoardState board) {
        Player player = owner.promptTargetPlayer(board);
        int index = owner.promptTargetIndex(board, 2);
        if (index == 10);
        else {
            Minion minion = player.getPlayerSide().get(index);
            minion.getEnchantments().add(new NightmareBuff(minion));
        }
    }

    private class NightmareBuff extends Enchantments {

        private NightmareBuff(CanHaveEnchantments link) {
            super(Keywords.STARTOFYOURTURN, "Destroy this minion at the start of the turn", link);
            link.getEnchantments().add(new AttackHealthBuff(link, 5, 5));
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                ((Minion) link).destroy(board);
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {
        }
    }
}
