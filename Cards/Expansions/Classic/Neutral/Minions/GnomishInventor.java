package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class GnomishInventor extends Minion {

    // State
    protected int hp = 4;
    protected int atk = 2;
    protected int cost = 4;
    protected String name = "Gnomish Inventor";
    protected String text = "Battlecry: Draw a Card";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public GnomishInventor(Player owner) {

        super(4, 2, 6, "Gnomish Inventor", owner,"Battlecry: Draw a Card", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player) {
        if (properties.contains(Keywords.BATTLECRY)) {
            owner.drawCard(board);
        }
    }
}
