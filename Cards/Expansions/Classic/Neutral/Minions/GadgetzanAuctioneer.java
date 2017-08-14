package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class GadgetzanAuctioneer extends Minion {

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

    public GadgetzanAuctioneer(Player owner) {

        super(4, 4, 6, "Gadgetzan Auctioneer", owner,"Whenever you cast a spell, draw a card.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.SPELLCASTED);
    }

    @Override
    public void spellCastedProc(Spell spell, BoardState board) {
        if (properties.contains(Keywords.SPELLCASTED)) {
            owner.drawCard();
        }
    }
}
