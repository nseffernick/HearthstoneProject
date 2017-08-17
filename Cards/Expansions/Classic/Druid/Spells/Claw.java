package Cards.Expansions.Classic.Druid.Spells;

import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

public class Claw extends Spell {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;
    protected ArrayList<Enchantments> enchantments;

    public Claw(Player owner) {

        super(1, "Claw", "Give your hero 2 attack and 2 armor", owner,
                Rarity.BASIC, HeroClass.DRUID);
    }

    @Override
    public void castSpell(BoardState board) {
        owner.getHero().addArmor(2);
        owner.getHero().addAtk(2);
    }
}