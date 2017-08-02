package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Gruul extends Minion {

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

    public Gruul(Player owner) {

        super(7, 7, 8, "Gruul", owner,"At the end of each turn, gain +1/+1 .", Rarity.LEGENDARY,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.ENDOFTURN);
    }

    @Override
    public void endOfTurn(BoardState board) {
        addAtk(1);
        addMaxHP(1);
        addHp(1, board);
    }
}