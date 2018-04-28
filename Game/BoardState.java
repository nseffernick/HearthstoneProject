package Game;

import Cards.Card;
import Game.Auras.Aura;
import Game.Player.*;
import Utility.AttackAndTargetBehaviors.MasterTargeter;

import java.util.LinkedList;


/**
 * ME 3/19/17
 * Class that will run the game essentially
 * Takes care of time constraints, starts and ends turns, access to all
 * players, mulligan phase.
 */
public class BoardState {

    // Constants
    private final int TIME_LIMIT = 90;
    private final int ROPE = 15;
    private final int STARTING_TURN = 0;

    // State
    private static Player p1;
    private static Player p2;
    private int turn;

    public BoardState(String deck1, String deck2, String hero1, String hero2) {
        this.turn = STARTING_TURN;
        Player p1 = new Player(deck1, hero1, 1);
        Player p2 = new Player(deck2, hero2, 2);
        startMulligan(p1, p2);
    }

    private void startMulligan(Player p1, Player p2) {
        p1.mulligan("first");
        p2.mulligan("second");
    }

    /**
     * Gain mana and draw a card
     * Probably will need to trigger start of turn effects as well
     * @param player
     */
    public void startTurn(Player player) {
        player.drawCard();
        if (!(player.getMana() == 10)) {
            player.addMana(1);
        }

    }

    public void hasWon(Player player) {

    }

    public static Player getP1() {
        return p1;
    }

    public static Player getP2() {
        return p2;
    }

    public void applyAura(Aura aura) {

        LinkedList<Card> where = determineWhere(aura);
    }

    private LinkedList<Card> determineWhere(Aura aura) {

        String[] text = aura.getWhere().split(" ");

        Player player;
        if (text[0].equals("Friendly")) {
            player = p1;
        }
        else if (text[0].equals("Enemy")) {
            player = p2;
        }
        else {
            player = null;
        }

        return MasterTargeter.CustomTarget(player,text[1],
                aura.getTribe(),aura.getLink());
    }

    private void determineEffect(String auraEffect) {

    }

    public static void removeAura(Aura aura) {

    }


}