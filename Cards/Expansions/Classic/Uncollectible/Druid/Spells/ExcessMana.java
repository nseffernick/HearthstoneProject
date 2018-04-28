package Cards.Expansions.Classic.Uncollectible.Druid.Spells;

import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

public class ExcessMana extends Spell {

    public ExcessMana(Player owner) {
        super(0, "Excess Mana", "Draw a card", owner, Rarity.BASIC, HeroClass.DRUID);
    }

    @Override
    public void castSpell(BoardState board) {
        owner.drawCard();
    }
}
