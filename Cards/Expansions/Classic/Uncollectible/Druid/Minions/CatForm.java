package Cards.Expansions.Classic.Uncollectible.Druid.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasCharge;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class CatForm extends Minion {

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


    public CatForm(Player owner) {

        super(4, 4, 5, "Druid of the Claw", owner,"Charge", Rarity.COMMON,
                Tribe.BEAST, HeroClass.DRUID, new ArrayList<Enchantments>());
        enchantments.add(new HasCharge(this));
    }

}