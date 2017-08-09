package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Tokens.FinkleEinhorn;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class TheBeast extends Minion {

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

    public TheBeast(Player owner) {

        super(7, 9, 6, "The Beast", owner, "Deathrattle: Summon a 3/3 Finkle Einhorn for your opponent.",
                Rarity.LEGENDARY, Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.DEATHRATTLE);
    }

    @Override
    public void deathrattle(BoardState board) {
        if (properties.contains(Keywords.DEATHRATTLE)) {
            UtilityMethods.findEnemy(board, owner).summonMinion(new FinkleEinhorn(UtilityMethods.findEnemy(board, owner)), board);
        }
    }
}