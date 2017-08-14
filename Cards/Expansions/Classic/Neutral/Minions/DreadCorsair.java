package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class DreadCorsair extends Minion {

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

    public DreadCorsair(Player owner) {

        super(3, 3, 4, "Dread Corsair", owner,"Taunt Costs one less for each attack on your weapon",
                Rarity.COMMON, Tribe.PIRATE, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.TAUNT);
        properties.add(Keywords.WEAPONSTATE);
    }

    @Override
    public void weaponState() {
        if (properties.contains(Keywords.WEAPONSTATE)) {
            if (owner.getHero().getWeapon() != null) {
                int discount = owner.getHero().getWeapon().getAtk();
                int newCost = 4 - discount;
                cost = newCost;
            }
        }
    }

}