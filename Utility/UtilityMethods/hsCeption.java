package Utility.UtilityMethods;

import Cards.Structure.Card;

import java.util.Random;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Cheech on 3/27/2017. nxs1720@g.rit.edu
 * Basically the random number generator used by the player
 */
public class hsCeption {

    // State
    private Random randomEffect;

    public hsCeption() {
        randomEffect = new Random();
    }

    /**
     * Shuffles deck
     * @param deck
     */
    public void shuffle(LinkedList<Card> deck) {
        Collections.shuffle(deck, randomEffect);
    }

    /**
     * Randomly generated number 0 to inclusive bound
     * @param bound
     * @return
     */
    public int randomNum(int bound) {
        return randomEffect.nextInt(bound);
    }

    public boolean randomBool() { return randomEffect.nextBoolean(); }

    //public Card discover() {
    //    return new RiverCroc();
    //}

    public void joust() {}

    public int firstOrSecond() {
        return randomNum(1);
    }
}
