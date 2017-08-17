package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Auras.Aura;
import Game.Auras.SouthseaCaptainAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class SouthseaCaptain extends Minion {

    // State
    protected int hp;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Enchantments> enchantments;

    public SouthseaCaptain(Player owner) {

        super(3, 3, 3, "Southsea Captain", owner,"Adjacent minions have +1 attack.",
                Rarity.EPIC, Tribe.PIRATE, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        //properties.add(Keywords.AURA);
    }

    public void createAura(BoardState board) {
        Aura thisAura = new SouthseaCaptainAura(this, "Southsea Captain Aura");
        owner.addAura(thisAura, board);
    }

}