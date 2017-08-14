package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.Devilsaur;
import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.Squirrel;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class TinkmasterOverspark extends Minion {

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

    public TinkmasterOverspark(Player owner) {

        super(3, 3, 3, "Tinkmaster Overspark", owner, "Battlecry: Transform another random minion" +
                        " into a 5/5 Devilsaur or a 1/1 Squirrel.",
                Rarity.LEGENDARY, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        int numTargets = owner.getPlayerSide().size() + owner.getPlayerSide().size();
        if (numTargets == 0);
        else {
            int index = owner.getRng().randomNum(numTargets);
            boolean bool = owner.getRng().randomBool();
            if (index < UtilityMethods.findEnemy(board, player).getPlayerSide().size()) {
                Minion tranformed;
                if (bool) {
                    tranformed = new Devilsaur(UtilityMethods.findEnemy(board, player));
                }
                else {
                    tranformed = new Squirrel(UtilityMethods.findEnemy(board, player));
                }
                UtilityMethods.findEnemy(board, player).getPlayerSide().set(index, tranformed);
            }
            else {
                index -= UtilityMethods.findEnemy(board, player).getPlayerSide().size();
                Minion tranformed;
                if (bool) {
                    tranformed = new Devilsaur(owner);
                }
                else {
                    tranformed = new Squirrel(owner);
                }
                UtilityMethods.findEnemy(board, player).getPlayerSide().set(index, tranformed);
            }
        }
    }
}
