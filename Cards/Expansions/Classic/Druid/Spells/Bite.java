package Cards.Expansions.Classic.Druid.Spells;

import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

public class Bite extends Spell {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;
    protected ArrayList<Enchantments> enchantments;

    public Bite(Player owner) {

        super(4, "Bite", "Give your hero 4 attack and 4 armor", owner,
                Rarity.BASIC, HeroClass.DRUID);
    }

    @Override
    public void castSpell(BoardState board) {
        owner.getHero().addArmor(4);
        owner.getHero().addAtk(4);
    }
}
