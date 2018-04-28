package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.BaineBloodhoof;
import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class CairneBloodhoof extends Minion {

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


    public CairneBloodhoof(Player owner) {

        super(5, 4, 6, "Cairne Bloodhoof", owner, "Deathrattle: Summon a 4/5 Baine Bloodhoof.",
                Rarity.LEGENDARY, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new DeathrattleBaine(this));
    }

    public static class DeathrattleBaine extends Enchantments {

        public DeathrattleBaine(CanHaveEnchantments link) {
            super(Keywords.DEATHRATTLE, "Deathrattle: Summon Baine", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                minionLink.getOwner().summonMinion(new BaineBloodhoof(minion.getOwner()), board);
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {
        }
    }
}