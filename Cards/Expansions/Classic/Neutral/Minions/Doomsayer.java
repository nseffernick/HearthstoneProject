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

public class Doomsayer extends Minion {

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

    public Doomsayer(Player owner) {

        super(4, 1, 3, "Demolisher", owner,"At the start of your turn, destroy all minions.",
                Rarity.EPIC, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.STARTOFYOURTURN);
    }

    @Override
    public void startOfYourTurn(BoardState board) {
        if (properties.contains(Keywords.STARTOFYOURTURN)) {
            for (Minion minion: owner.getPlayerSide()) {
                minion.destroy(board);
            }
            for (Minion minion: UtilityMethods.findEnemy(board, owner).getPlayerSide()) {
                minion.destroy(board);
            }
        }
    }
}