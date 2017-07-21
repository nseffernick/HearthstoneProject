package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Representation of the Magma Rager Minion
 */
public class MagmaRager extends Minion {

    // State
    public int hp = 1;
    public int atk = 5;
    public int cost = 3;
    public String name = "Magma Rager";
    private String text = "";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.ELEMENTAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public MagmaRager(Player owner) {

        super(1, 5, 3, "Magma Rager", owner,"", Rarity.BASIC,
                Tribe.ELEMENTAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }


    @Override
    public void onDeath() {

    }

    @Override
    public void onSummon() {

    }

    @Override
    public void onTurnStart() {

    }
}