package Utility.UtilityMethods;

import Cards.Card;
import Game.Player.Player;
import Cards.Classic.Neutral.Minions.RiverCroc;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;

import java.util.*;

/**
 * Created by Cheech on 3/27/2017. nxs1720@g.rit.edu
 * Basically the random number generator used by the player
 */
public class hsCeption {

    // State
    private Random randomEffect;

    public hsCeption() {
        randomEffect = new Random(3);
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

    public Card discover() {
        return new RiverCroc();
    }

    public void joust() {}

    public int firstOrSecond() {
        return randomNum(1);
    }
}
