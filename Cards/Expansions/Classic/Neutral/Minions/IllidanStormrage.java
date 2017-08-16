package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.FlameOfAzzinoth;
import Cards.Structure.CanHaveEnchantments;
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

public class IllidanStormrage extends Minion {

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

    public IllidanStormrage(Player owner) {

        super(5, 7, 6, "Illidan Stormrage", owner,"Whenever you play a card, summon a 2/1 Flame of Azzinoth.",
                Rarity.LEGENDARY, Tribe.DEMON, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new IllidanText(this));
    }

    public static class IllidanText extends Enchantments {

        public IllidanText(CanHaveEnchantments link) {
            super(Keywords.CARDPLAYED, "Spawn Flame of Azzinoths", link);
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                minionLink.getOwner().summonMinion(new FlameOfAzzinoth(minionLink.getOwner()), board);
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {

        }
    }
}
