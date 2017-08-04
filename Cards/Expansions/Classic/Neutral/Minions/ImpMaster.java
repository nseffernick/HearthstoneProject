package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Tokens.Imp;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

// I am not a morning person
public class ImpMaster extends Minion {

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

    public ImpMaster(Player owner) {

        super(5, 1, 3, "Imp Master", owner,"At the end of your turn, deal 1 damage to this minion and summon a 1/1 Imp.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.ENDOFYOURTURN);
    }

    @Override
    public void endOfYourTurn(BoardState board) {
        if (properties.contains(Keywords.ENDOFYOURTURN)) {
            owner.summonCard(new Imp(owner), board);
            addHp(-1, board);
        }
    }
}