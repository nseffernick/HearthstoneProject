package Cards.Expansions.Classic.Neutral.Minions;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class SpitefulSmith extends Minion {

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

    public SpitefulSmith(Player owner) {

        super(6, 4, 5, "Spiteful Smith", owner, "Enrage: your weapon gains +2 attack",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new SpitefulText(this));
        boolean enraged = false;
    }

    private class SpitefulText extends Enchantments {

        private SpitefulText(CanHaveEnchantments link) {
            super(Keywords.ENRAGE, "Gain Attack and Windfury", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                if (enraged) owner.getHero().getWeapon().addAtk(-2);
                else owner.getHero().getWeapon().addAtk(2);
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {
            if (enraged) owner.getHero().getWeapon().addAtk(-2);
        }
    }
}