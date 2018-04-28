package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Text.DeathrattleDraw;
import Utility.Enchantments.Enchantments.Keywords.SpellDamage1;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class BloodmageThalnos extends Minion {

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

    public BloodmageThalnos(Player owner) {

        super(1, 1, 2, "Bloodmage Thalnos", owner, "Spell Damage +1. Deathrattle: Draw a card.",
                Rarity.LEGENDARY, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new SpellDamage1(this));
        enchantments.add(new DeathrattleDraw(this));
    }

    @Override
    public void deathrattle(BoardState board) {
        owner.drawCard();
    }
}