package Player;

import Cards.Card;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 */
public class Player {

    // CONSTANTS
    private final int STARTING_MANA = 0;
    private final int BOARD_SLOTS = 7;
    private final int MAX_HAND_SIZE = 10;

    // State
    public int mana;
    public LinkedList<Card> playerSide;
    public LinkedList<Card> deck;
    public LinkedList<Card> hand;
    public Hero hero;
    private int fatigue;
    // private AI type;

    public Player(String decklist, String Hero) {
        this.mana = STARTING_MANA;
        // need to initialize hero
        this.hero = hero;
        this.playerSide = new LinkedList<>();
        this.deck = initializeDeck(decklist);
    }

    private LinkedList<Card> initializeDeck(String decklist) {
        LinkedList<Card> deck = new LinkedList<>();
        String[] decklistArr = decklist.split(" ");
        for (String card: decklistArr) {
            try {
                // WHY HAS NO ONE TOLD ME ABOUT THIS
                Object newCard = Class.forName(card);
                deck.add(((Card)newCard));
            }
            catch (ClassNotFoundException e) {
                System.out.println("This is not a card!");
                e.printStackTrace();
            }
        }
        return deck;
    }

    public Queue getDeck() {
        return deck;
    }

    public Queue getHand() {
        return hand;
    }

    public void endTurn() {

    }

    /**
     * Pre-Condition gives a correct index
     * Very rough, will definitely need to update
     * @param card - card player is playing from hand
     */
    public void playCard(Card card, int index) {
        if (playerSide.size() < BOARD_SLOTS) {
            hand.remove(card);
            if (playerSide.isEmpty()) {
                playerSide.add(card);
            }
            else playerSide.add(index, card);
        }
    }

    public void drawCard() {
        if (!deck.isEmpty()) {
            Card card = deck.remove();
            if (hand.size() < MAX_HAND_SIZE) {
                hand.add(card);
            }
            else {
                System.out.println(card + " was burned!");
            }
        }
        else {
            fatigue += 1;
            hero.hp -= fatigue;
        }
    }

    public void heroPower(Hero hero) {

    }

    public void mulligan(String position) {
        Scanner chooseCard = new Scanner(System.in);
        int i = 0;
        int drawMore = 0;
        if (position.equals("first")) {
            System.out.println("You are going first.");
            drawCard();
            drawCard();
            drawCard();
            System.out.println("Choose which cards to put back in your deck.");
            for (Card card: hand) {
                if (mulliganHelper(card, chooseCard)) {
                    deck.add(hand.remove(i));
                    drawMore += 1;
                }
                i += 1;
            }
            while (drawMore > 0){
                drawCard();
                drawMore -= 1;
            }
        }
        else {
            System.out.println("You are going second.");
            drawCard();
            drawCard();
            drawCard();
            drawCard();
            System.out.println("Choose which cards to put back in your deck.");
            for (Card card: hand) {
                if (mulliganHelper(card, chooseCard)) {
                    deck.add(hand.remove(i));
                    drawMore += 1;
                }
                i += 1;
            }
            while (drawMore > 0){
                drawCard();
                drawMore -= 1;
            }
        }
    }

    private boolean mulliganHelper(Card card, Scanner choose) {
        System.out.println("Mull back " + card + "?  (Y/N)");
        if (choose.next().equals("Y") || choose.next().equals("y")) {
            return true;
        }
        else if (choose.next().equals("N") || choose.next().equals("n")) {
            return false;
        }
        System.out.println("Use correct response next time.");
        return false;
    }

}