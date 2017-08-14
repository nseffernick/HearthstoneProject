package Cards.Expansions.Classic.Uncollectible.Neutral.Spells;

import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

public class YseraAwakens extends Spell {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;
    protected ArrayList<Keywords> properties;

    public YseraAwakens(Player owner) {

        super(2, "Ysera Awakens", "Deal 5 damage to all characters except Ysera", owner,
                Rarity.BASIC, HeroClass.NEUTRAL, new ArrayList<>());
    }

    @Override
    public void castSpell(BoardState board) {
        damageAllCharacters(board, 5);
    }
}
