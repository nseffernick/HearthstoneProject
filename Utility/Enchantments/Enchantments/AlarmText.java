package Utility.Enchantments.Enchantments;

import Cards.Expansions.Classic.Neutral.Minions.AlarmOBot;
import Cards.Structure.Card;
import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class AlarmText extends Enchantments {

    public AlarmText(Minion link) {
        super(Keywords.STARTOFYOURTURN, "Alarm O Bot Replace", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        if (checkForKeyword(Keywords.STARTOFYOURTURN, minion)) {
            if (minion.getOwner().getHand().isEmpty());
            int handSize = minion.getOwner().getHand().size() - 1;
            int randomNum = minion.getOwner().getRng().randomNum(handSize);
            for (Card card: minion.getOwner().getHand()) {
                if (card instanceof Minion) {
                    while (!(minion.getOwner().getHand().get(randomNum) instanceof Minion)) {
                        randomNum = minion.getOwner().getRng().randomNum(handSize);
                    }
                    replaceBot(board, randomNum, minion);
                    break;
                }
            }
        }
    }

    private void replaceBot(BoardState board, int randomNum, Minion minion) {
        minion.getOwner().getPlayerSide().remove(this);
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
