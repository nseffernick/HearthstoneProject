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

public class Secretkeeper extends Minion {

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

    public Secretkeeper(Player owner) {

        super(2, 1, 1, "Secretkeeper", owner,"Whenever a Secret is played, gain +1/+1.", Rarity.RARE,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }

    @Override
    public void spellCastedProc(Spell spell, BoardState board) {
        if (spell.getProperties().contains(Keywords.SECRET)) {
            addAtk(1);
            addMaxHP(1);
            addHp(1, board);
        }
    }
}