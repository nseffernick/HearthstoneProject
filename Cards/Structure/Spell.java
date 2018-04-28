package Cards.Structure;

import Game.BoardState;
import Utility.Rarities.Rarity;
import Utility.HeroClasses.HeroClass;
import Game.Player.Player;

/**
 *
 */
public abstract class Spell extends Card {

    // State
    protected int cost;
    protected Rarity rarity;
    protected HeroClass heroClass;
    protected String name;
    protected String text;
    protected Player owner;

    public Spell(int cost, String name, String text, Player owner, Rarity rarity,
                 HeroClass heroClass) {
        super(cost, name, text, owner, rarity, heroClass);

        this.cost = cost;
        this.name = name;
        this.text = text;
        this.owner = owner;
        this.rarity = rarity;
        this.heroClass = heroClass;
    }

    public Spell(Spell spell) {
        super(spell);
    }

    public abstract void castSpell(BoardState board);
}




