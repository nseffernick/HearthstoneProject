package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Tokens.VioletApprentice;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class VioletTeacher extends Minion {

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

    public VioletTeacher(Player owner) {

        super(5, 3, 4, "Violet Teacher", owner,"After you cast a spell, summon a 1/1 Violet Apprentice",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.SPELLCASTED);
    }

    @Override
    public void spellCastedProc(Spell spell, BoardState board) {
        if (properties.contains(Keywords.SPELLCASTED)) {
            owner.summonMinion(new VioletApprentice(owner), board);
        }
    }
}