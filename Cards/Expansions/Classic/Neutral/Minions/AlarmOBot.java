package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.CanHaveEnchantments;
import Cards.Structure.Card;
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

//TODO need to implement some sort of refresh method on cards
public class AlarmOBot extends Minion {

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

    public AlarmOBot(Player owner) {

        super(3, 0, 3, "Alarm-o-Bot", owner,"At the start of your turn, swap this minion with one in your hand.", Rarity.RARE,
                Tribe.MECH, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new AlarmText(this));
    }


    public static class AlarmText extends Enchantments {

        public AlarmText(CanHaveEnchantments link) {
            super(Keywords.STARTOFYOURTURN, "Alarm O Bot Replace", link);
        }

        @Override
        protected void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                if (minion.getOwner().getHand().isEmpty());
                int handSize = minionLink.getOwner().getHand().size() - 1;
                int randomNum = minionLink.getOwner().getRng().randomNum(handSize);
                for (Card card: minionLink.getOwner().getHand()) {
                    if (card instanceof Minion) {
                        while (!(minionLink.getOwner().getHand().get(randomNum) instanceof Minion)) {
                            randomNum = minionLink.getOwner().getRng().randomNum(handSize);
                        }
                        replaceBot(board, randomNum, minionLink);
                        break;
                    }
                }
            }
        }

        private void replaceBot(BoardState board, int randomNum, Minion minion) {
            minion.getOwner().getPlayerSide().remove(minion);
            Minion otherMinion = (Minion) minion.getOwner().getHand().get(randomNum);
            minion.getOwner().summonMinion(otherMinion, board);
            AlarmOBot newAlarmOBot = new AlarmOBot(minion.getOwner());
            if (minion.getOwner().getHand().size() > 10);
            else minion.getOwner().getHand().add(newAlarmOBot);
        }

        @Override
        protected void disenchant(BoardState board, Minion minion) {

        }
    }
}