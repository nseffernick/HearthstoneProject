package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Card;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
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
    protected ArrayList<Keywords> properties;

    public AlarmOBot(Player owner) {

        super(3, 0, 3, "Alarm-o-Bot", owner,"At the start of your turn, swap this minion with one in your hand.", Rarity.LEGENDARY,
                Tribe.ELEMENTAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.STARTOFYOURTURN);
    }

    @Override
    public void startOfYourTurn(BoardState board) {
        if (properties.contains(Keywords.STARTOFYOURTURN)) {
            if (owner.getHand().isEmpty());
            int handSize = owner.getHand().size() - 1;
            int randomNum = owner.getRng().randomNum(handSize);
            for (Card card: owner.getHand()) {
                if (card instanceof Minion) {
                    while (!(owner.getHand().get(randomNum) instanceof Minion)) {
                        randomNum = owner.getRng().randomNum(handSize);
                    }
                    replaceBot(board, randomNum);
                    break;
                }
            }
        }
    }

    private void replaceBot(BoardState board, int randomNum) {
        owner.getPlayerSide().remove(this);
        Minion minion = (Minion) owner.getHand().get(randomNum);
        owner.summonMinion(minion, board);
        AlarmOBot newAlarmOBot = new AlarmOBot(owner);
        if (owner.getHand().size() > 10);
        else owner.getHand().add(newAlarmOBot);
    }
}