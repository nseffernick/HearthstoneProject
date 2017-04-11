package Player;

import Cards.Card;
import Cards.Minion;
import Cards.Spell;
import Utility.UtilityMethods.hsCeption;

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
    private int manaCyrstals;
    private int mana;
    private int spellDamage;
    private LinkedList<Minion> playerSide;
    private LinkedList<Card> deck;
    private LinkedList<Card> hand;
    private Hero hero;
    private int fatigue;
    private hsCeption rng;
    // private AI type;

    public Player(String decklist, String Hero) {
        this.mana = STARTING_MANA;
        // need to initialize hero
        this.hero = hero;
        this.playerSide = new LinkedList<>();
        this.deck = initializeDeck(decklist);
        rng = new hsCeption();
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
        rng.shuffle(this);
        return deck;
    }

    public int getManaCyrstals() {
        return manaCyrstals;
    }

    public int getMana() {
        return mana;
    }

    public int getFatigue() {
        return fatigue;
    }

    public LinkedList<Minion> getPlayerSide() {
        return playerSide;
    }

    public LinkedList<Card> getDeck() {
        return deck;
    }

    public LinkedList<Card> getHand() {
        return hand;
    }

    public Hero getHero() {
        return hero;
    }

    public hsCeption getRng() {
        return rng;
    }

    public int getSpellDamage() {
        return spellDamage;
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
            rng.shuffle(this);
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
            rng.shuffle(this);
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


    public boolean endTurn() {
        return true;
    }

    /**
     * Pre-Condition gives a correct index
     * Very rough, will definitely need to update
     * @param card - card player is playing from hand
     */
    public void playCard(Card card, int index) {
        if (playerSide.size() < BOARD_SLOTS) {
            hand.remove(card);
            // If card is a minion
            if (card instanceof Minion) {
                Minion minion = (Minion)(card);
                if (playerSide.isEmpty()) {
                    playerSide.add(minion);
                }
                else playerSide.add(index, minion);
            }
            // If card is a spell
            else if (card instanceof Spell) {

            }
        }
    }

    public void summonCard(Minion minion) {
        if (playerSide.size() < BOARD_SLOTS) {
            playerSide.add(minion);
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

    public void heroPower(Player player, int index) {
        getHero().getHeroPower().Cast(player, index);
    }


}