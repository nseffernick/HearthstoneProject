package Cards.Expansions.Classic.Druid.Spells;

import Cards.Expansions.Classic.Uncollectible.Druid.Minions.Treant;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

public class ForceOfNature extends Spell {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;
    protected ArrayList<Enchantments> enchantments;

    public ForceOfNature(Player owner) {

        super(5, "Force of Nature", "Summon 3 2/2 Treants", owner,
                Rarity.BASIC, HeroClass.DRUID);
    }

    @Override
    public void castSpell(BoardState board) {
        owner.summonMinion(new Treant(owner), board);
        owner.summonMinion(new Treant(owner), board);
        owner.summonMinion(new Treant(owner), board);
    }
}