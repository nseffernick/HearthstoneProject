package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class WildPyromancer extends Minion {

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

    public WildPyromancer(Player owner) {

        super(2, 3, 2, "Wild Pyromancer", owner,"After you cast a spell, deal 1 damage to ALL minions.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.SPELLCASTED);
    }

    @Override
    public void spellCastedProc(Spell spell, BoardState board) {
        if (properties.contains(Keywords.SPELLCASTED)) {
            for (Minion minion: owner.getPlayerSide()) {
                addHp(-1, board);
            }
            for (Minion minion: UtilityMethods.findEnemy(board, owner).getPlayerSide()) {
                addHp(-1, board);
            }
        }
    }
}