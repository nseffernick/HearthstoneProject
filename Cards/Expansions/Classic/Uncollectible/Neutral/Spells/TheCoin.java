package Cards.Expansions.Classic.Uncollectible.Neutral.Spells;

import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

public class TheCoin extends Spell {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;

    public TheCoin(Player owner) {

        super(0, "The Coin", "Give yourself one mana this turn.", owner,
                Rarity.BASIC, HeroClass.NEUTRAL);
    }

    @Override
    public void castSpell(BoardState board) {

    }
}
