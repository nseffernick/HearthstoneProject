package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class LorewalkerCho extends Minion {

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

    public LorewalkerCho(Player owner) {

        super(4, 0, 2, "Lorewalker Cho", owner,"Whenever a player casts a spell, put a copy into the other player’s hand.",
                Rarity.LEGENDARY, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.SPELLCASTED);
    }

    @Override
    public void spellCastedProc(Spell spell, BoardState board) {
        if (properties.contains(Keywords.SPELLCASTED)) {
            Player caster = spell.getOwner();
            Player enemyPlayer = UtilityMethods.findEnemy(board, caster);
            if (enemyPlayer.getHand().size() < 10) {
                //TODO this new copy creation shit
                Spell newSpell = spell;
                newSpell.setOwner(enemyPlayer);
                enemyPlayer.getHand().add(newSpell);
            }
        }
    }
}
