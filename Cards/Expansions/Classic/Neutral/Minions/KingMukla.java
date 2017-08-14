package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Spells.Banana;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class KingMukla extends Minion {

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

    public KingMukla(Player owner) {

        super(5, 5, 3, "King Mukla", owner, "Battlecry: Give your opponent 2 Bananas.",
                Rarity.LEGENDARY, Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (UtilityMethods.findEnemy(board, player).getHand().size() < 10) {
            UtilityMethods.findEnemy(board, player).getHand().add(new Banana(UtilityMethods.findEnemy(board, player)));
        }
        if (UtilityMethods.findEnemy(board, player).getHand().size() < 10) {
            UtilityMethods.findEnemy(board, player).getHand().add(new Banana(UtilityMethods.findEnemy(board, player)));
        }
    }
}