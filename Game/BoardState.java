package Game;

import Cards.Card;
import Cards.Minion;
import Game.Auras.Aura;
import Game.Player.*;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.Keywords.Keywords;

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
    private static LinkedList<Aura> auras;
    private int turn;

    public BoardState(String deck1, String deck2, String hero1, String hero2) {
        this.turn = STARTING_TURN;
        this.auras = new LinkedList<Aura>();
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

    public LinkedList<Aura> getAuras() { return auras;};

    private static void applyAura(Aura aura) {

        LinkedList<Minion> where = determineWhere(aura);
        String[] text = aura.getEffect().split(" ");
        int increment = getIncrement(text);
        modifyWhere(where, text, increment);
    }

    private static LinkedList<Minion> determineWhere(Aura aura) {

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

    private static void modifyWhere(LinkedList<Minion> where, String[] text, int increment) {

        for (Minion minions: where) {

            if(text[0].equals("Attack")) {
                minions.addAtk(increment);
            }
            else if(text[0].equals("Health")) {
                minions.addMaxHP(increment);
                minions.addHp(increment);
            }
            else if(text[0].equals("Attack/Health")) {
                minions.addMaxHP(increment);
                minions.addHp(increment);
                minions.addAtk(increment);
            }
            else if(text[0].equals("Cost")) {
                minions.addCost(increment);
            }
        }

    }

    private static int getIncrement(String[] text) {

        int increment = Integer.parseInt(text[2]);
        if(text[1].charAt(0) ==  '-') {
            increment = increment - (2*increment);
        }
        return increment;

    }

    public void removeAura(Aura aura) {

        if (checkAlive(aura));
        else {

            LinkedList<Minion> where = determineWhere(aura);
            String[] text = aura.getEffect().split(" ");
            int increment = getIncrement(text);
            increment = increment - (2*increment);
            modifyWhere(where, text, increment);
        }

    }

    private boolean checkAlive(Aura aura) {
        if (aura.getLink().isDead() || !aura.getLink().getProperties().contains(Keywords.AURA)) {
            return false;
        }
        return true;
    }

    public static void addAura(Aura aura) {
        auras.add(aura);
        applyAura(aura);
    }

}