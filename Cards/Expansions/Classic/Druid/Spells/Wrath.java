package Cards.Expansions.Classic.Druid.Spells;

import Cards.Structure.ChooseOne;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;

public class Wrath extends Spell implements ChooseOne {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;

    public Wrath(Player owner) {

        super(0, "Innervate", "Give yourself two mana this turn.", owner,
                Rarity.BASIC, HeroClass.DRUID);
    }

    @Override
    public void castSpell(BoardState board) {
        owner.addMana(2);
    }

    @Override
    public boolean presentChoice(BoardState board) {
        return false;
    }

    /*
    @Override
    public void fandralInteratction(BoardState board) {

    }
    */
}