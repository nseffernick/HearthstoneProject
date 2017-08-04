package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class ManaAddict extends Minion {

    // State
    protected int hp;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Keywords> properties;

    public ManaAddict(Player owner) {

        super(3, 1, 2, "Mana Addict", owner,"Whenever you cast a spell, gain +2 Attack this turn.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.SPELLCASTED);
    }

    @Override
    public void spellCastedProc(Spell spell, BoardState board) {
        if (properties.contains(Keywords.SPELLCASTED)) {
            addAtk(2);
        }
    }
}
