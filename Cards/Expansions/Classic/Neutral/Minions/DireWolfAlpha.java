package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Auras.Aura;
import Game.Auras.DireWolfAlphaAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class DireWolfAlpha extends Minion {

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

    public DireWolfAlpha(Player owner) {

        super(2, 2, 2, "Dire Wolf Alpha", owner,"Adjacent minions have +1 attack.", Rarity.COMMON,
                Tribe.BEAST, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.AURA);
    }

    public void createAura(BoardState board) {
        Aura thisAura = new DireWolfAlphaAura(this, "Dire Wolf Alpha Aura");
        owner.addAura(thisAura, board);
    }

}
