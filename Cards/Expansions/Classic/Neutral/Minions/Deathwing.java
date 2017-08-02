package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Card;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Deathwing extends Minion {

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

    public Deathwing(Player owner) {

        super(12, 12, 10, "Deathwing", owner,"Destroy every minion and discard every card in your hand", Rarity.LEGENDARY,
                Tribe.DRAGON, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player) {
        for (Minion minion: board.getP1().getPlayerSide()) {
            minion.destroy(board);
        }
        for (Minion minion: board.getP2().getPlayerSide()) {
            minion.destroy(board);
        }
        for (Card card: owner.getHand()) {
            owner.discard(card);
        }
    }
}