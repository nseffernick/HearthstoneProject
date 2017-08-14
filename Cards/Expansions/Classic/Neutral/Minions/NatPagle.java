package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class NatPagle extends Minion {

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

    public NatPagle(Player owner) {

        super(4, 0, 2, "Nat Pagle", owner,"At the start of your turn, you have a 50% chance to draw an extra card.",
                Rarity.LEGENDARY, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.STARTOFYOURTURN);
    }

    @Override
    public void startOfYourTurn(BoardState board) {
        if (properties.contains(Keywords.STARTOFYOURTURN)) {
            boolean maybeDraw = owner.getRng().randomBool();
            if (maybeDraw) { owner.drawCard(); }
        }
    }
}