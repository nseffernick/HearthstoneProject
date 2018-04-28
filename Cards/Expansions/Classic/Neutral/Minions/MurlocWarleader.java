package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Auras.Aura;
import Game.Auras.MurlocWarleaderAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class MurlocWarleader extends Minion {

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

    public MurlocWarleader(Player owner) {

        super(3, 3, 3, "Murloc Warleader", owner,
                "Your other murlocs have +2/+1", Rarity.EPIC,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        //properties.add(Keywords.AURA);
    }

    public void createAura(BoardState board) {
        Aura thisAura = new MurlocWarleaderAura(this, "Murloc Warleader Aura");
        owner.addAura(thisAura, board);
    }

}