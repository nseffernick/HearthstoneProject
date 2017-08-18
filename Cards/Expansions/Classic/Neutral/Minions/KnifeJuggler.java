package Cards.Expansions.Classic.Neutral.Minions;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class KnifeJuggler extends Minion {

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

    public KnifeJuggler(Player owner) {

        super(2, 2, 2, "Knife Juggler", owner,"Whenever you summon a minion, deal one damage to a random enemy character",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new KnifeJugglerText(this));
    }

    private class KnifeJugglerText extends Enchantments {

        private KnifeJugglerText(CanHaveEnchantments link) {
            super(Keywords.MINIONSUMMONED, "Throws Knives at Enemies", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            int index = owner.getRng().randomNum(UtilityMethods.findEnemy(board, owner).getPlayerSide().size()) - 1;
            Damaging.damageCharacter(UtilityMethods.findEnemy(board, owner), index, 1, board);
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {

        }
    }
}