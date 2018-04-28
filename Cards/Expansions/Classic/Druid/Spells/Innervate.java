package Cards.Expansions.Classic.Druid.Spells;

import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;

public class Innervate extends Spell {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;

    public Innervate(Player owner) {

        super(0, "Innervate", "Give yourself two mana this turn.", owner,
                Rarity.BASIC, HeroClass.DRUID);
        System.out.println("ding fong");
    }

    @Override
    public void castSpell(BoardState board) {
        owner.addMana(2);
    }
}
