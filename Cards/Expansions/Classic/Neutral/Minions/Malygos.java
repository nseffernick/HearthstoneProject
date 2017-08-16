package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.SpellDamage1;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Malygos extends Minion {

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

    public Malygos(Player owner) {

        super(12, 4, 9, "Malygos", owner,"Spell Damage +5", Rarity.LEGENDARY,
                Tribe.DRAGON, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new SpellDamage1(this));
        enchantments.add(new SpellDamage1(this));
        enchantments.add(new SpellDamage1(this));
        enchantments.add(new SpellDamage1(this));
        enchantments.add(new SpellDamage1(this));
    }
}