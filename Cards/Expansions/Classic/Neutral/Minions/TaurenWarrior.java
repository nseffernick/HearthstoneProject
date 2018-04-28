package Cards.Expansions.Classic.Neutral.Minions;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class TaurenWarrior extends Minion {

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

    public TaurenWarrior(Player owner) {

        super(3, 2, 3, "Tauren Warrior", owner, "Taunt Enrage: +3 Attack",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new TaurenEnrageText(this));
        enchantments.add(new HasTaunt(this));
    }

    private class TaurenEnrageText extends Enchantments {

        private TaurenEnrageText(CanHaveEnchantments link) {
            super(Keywords.ENRAGE, "Gain Attack and Windfury", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                if (enraged) addAtk(-3);
                else addAtk(3);
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {
            if (enraged) addAtk(-3);
        }
    }
}