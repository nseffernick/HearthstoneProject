package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class LeperGnome extends Minion {

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

    public LeperGnome(Player owner) {

        super(1, 1, 1, "Leper Gnome", owner,"Deathrattle: Deal 2 damage to the enemy hero.",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.DEATHRATTLE);
    }

    @Override
    public void deathrattle(BoardState board) {
        if (properties.contains(Keywords.DEATHRATTLE)) {
            UtilityMethods.findEnemy(board, owner).getHero().addHp(UtilityMethods.findEnemy(board, owner), -2);
        }
    }
}