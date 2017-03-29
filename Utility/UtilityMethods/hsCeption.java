package Utility.UtilityMethods;

import Cards.Card;
import Player.Player;
import Cards.Classic.Neutral.Minions.RiverCroc;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Cheech on 3/27/2017. nxs1720@g.rit.edu
 */
public class hsCeption {

    // State
    private Random randomEffect;

    public hsCeption() {
        randomEffect = new Random(3);
    }

    public void shuffle(Player player) {
        Collections.shuffle(player.deck, randomEffect);
    }

    public int randomNum(int bound) {
        return randomEffect.nextInt(bound);
    }

    public Card discover() {
        return new RiverCroc();
    }

    public void joust() {

    }

    public int firstOrSecond() {
        return randomNum(1);
    }
}
