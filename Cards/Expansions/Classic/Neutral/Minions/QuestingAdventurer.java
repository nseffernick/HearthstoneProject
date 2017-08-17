package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.Gnoll;
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
//TODO TODO
public class QuestingAdventurer extends Minion {

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

    public QuestingAdventurer(Player owner) {

        super(2, 2, 3, "Questing Adventurer", owner,"Whenever you play a card, gain +1/+1.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new QuestingText(this));
    }

    private class QuestingText extends Enchantments {

        private int quests;

        private QuestingText(CanHaveEnchantments link) {
            super(Keywords.CARDPLAYED, "Quest to improve stats", link);
            quests = 0;
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                addAtk(1);
                addMaxHP(1);
                quests += 1;
            }
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                addAtk(-quests);
                addMaxHP(-quests);
            }
        }
    }
}