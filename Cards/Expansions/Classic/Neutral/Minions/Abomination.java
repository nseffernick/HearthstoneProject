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

public class Abomination extends Minion {

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

    public Abomination(Player owner) {

        super(4, 4, 5, "Abomination", owner,"Taunt. Deathrattle: Deal 2 damage to ALL characters.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.DEATHRATTLE);
        properties.add(Keywords.TAUNT);
    }

    @Override
    public void deathrattle(BoardState board) {
        if (properties.contains(Keywords.DEATHRATTLE)) {
            owner.getHero().addHp(owner, -2);
            UtilityMethods.findEnemy(board, owner).getHero().addHp(UtilityMethods.findEnemy(board, owner), -2);
            for (Minion minion: owner.getPlayerSide()) {
                minion.addHp(-2, board);
            }
            for (Minion minion: UtilityMethods.findEnemy(board, owner).getPlayerSide()) {
                minion.addHp(-2, board);
            }
        }
    }
}
