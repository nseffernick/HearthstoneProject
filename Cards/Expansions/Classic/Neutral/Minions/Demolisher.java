package Cards.Expansions.Classic.Neutral.Minions;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Damaging.Damaging;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class Demolisher extends Minion {

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

    public Demolisher(Player owner) {

        super(4, 1, 3, "Demolisher", owner,"At the start of your turn, deal 2 damage to a random enemy.",
                Rarity.RARE, Tribe.MECH, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new DemolisherBombs(this));
    }

    public static class DemolisherBombs extends Enchantments {

        public DemolisherBombs(CanHaveEnchantments link) {
            super(Keywords.STARTOFYOURTURN, "Hurls 2 damage bombs", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                int index = minionLink.getOwner().getRng().randomNum(UtilityMethods.findEnemy(board, minionLink.getOwner()).getPlayerSide().size()) - 1;
                Damaging.damageCharacter(UtilityMethods.findEnemy(board, minionLink.getOwner()), index, 2, board);
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {
        }
    }
}