package Cards.Expansions.Classic.Druid.Spells;

import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Enchantments.Text.AttackHealthBuff;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;

public class MarkOfTheWild extends Spell {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;

    public MarkOfTheWild(Player owner) {

        super(2, "Mark of the Wild", "Give a Minion +2/+2 and Taunt", owner,
                Rarity.BASIC, HeroClass.DRUID);
    }

    @Override
    public void castSpell(BoardState board) {
        Minion minion = owner.promptAMinion(board, 3);
        minion.getEnchantments().add(new AttackHealthBuff(minion, 2, 2));
        minion.getEnchantments().add(new HasTaunt(minion));
    }
}
