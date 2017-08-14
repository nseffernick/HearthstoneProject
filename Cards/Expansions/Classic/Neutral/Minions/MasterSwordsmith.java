package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class MasterSwordsmith extends Minion {

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

    public MasterSwordsmith(Player owner) {

        super(3, 1, 2, "Master Swordsmith", owner,"At the end of your turn, give another random friendly minion +1 Attack.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.ENDOFYOURTURN);
    }

    @Override
    public void endOfYourTurn(BoardState board) {
        if (properties.contains(Keywords.ENDOFYOURTURN)) {
            if (!(owner.getPlayerSide().size() == 1)) {
                int index = owner.getRng().randomNum(owner.getPlayerSide().size());
                while (!(owner.getPlayerSide().get(index) == this)) {
                    index = owner.getRng().randomNum(owner.getPlayerSide().size());
                }
                owner.getPlayerSide().get(index).addAtk(1);
            }
        }
    }
}