package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Spells.Dream;
import Cards.Expansions.Classic.Uncollectible.Neutral.Spells.Nightmare;
import Cards.Expansions.Classic.Uncollectible.Neutral.Spells.YseraAwakens;
import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.EmeraldDrake;
import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.LaughingSister;
import Game.CanHaveEnchantments;
import Cards.Structure.Card;
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

public class Ysera extends Minion {

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

    public Ysera(Player owner) {

        super(12, 4, 9, "Ysera", owner,"At the end of your turn, add a Dream Card to your hand.", Rarity.LEGENDARY,
                Tribe.DRAGON, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new YseraText(this));
    }

    private class YseraText extends Enchantments {

        private YseraText(CanHaveEnchantments link) {
            super(Keywords.ENDOFYOURTURN, "Spawn Gnolls", link);
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            int randomNum = owner.getRng().randomNum(5);
            Card dreamCard;
            if (randomNum == 0) {
                dreamCard = new EmeraldDrake(owner);
            }
            else if (randomNum == 1) {
                dreamCard = new LaughingSister(owner);
            }
            else if (randomNum == 2) {
                dreamCard = new Dream(owner);
            }
            else if (randomNum == 3) {
                dreamCard = new Nightmare(owner);
            }
            else  {
                dreamCard = new YseraAwakens(owner);
            }
            if (owner.getHand().size() < 10) {
                owner.getHand().add(dreamCard);
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {

        }
    }
}
