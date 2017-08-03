package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class MurlocTidecaller extends Minion {

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

    //TODO a Minion SUMMONED trigger
    public MurlocTidecaller(Player owner) {

        super(2, 1, 1, "Murloc Tidecaller", owner,"Whenever you summon a Murloc, gain +1 Attack.", Rarity.RARE,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.MINIONSUMMONED);
    }

    @Override
    public void minionSummonedProc(Minion minion, BoardState board) {
        if (properties.contains(Keywords.MINIONSUMMONED)) {
            addAtk(1);
        }
    }
}