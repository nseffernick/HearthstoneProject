package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/11/2017.
 */
public class NoviceEngineer extends Minion {
    // State
    public int hp = 1;
    public int atk = 1;
    public int cost = 2;
    public String name = "Novice Engineer";
    private String text = "Battlecry: Draw a Card";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.GENERAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public NoviceEngineer(Player owner) {

        super(1, 1, 2, "Novice Engineer", owner,"Battlecry: Draw a Card", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
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

    public void battlecry() {
        if (properties.contains(Keywords.BATTLECRY)) {
            owner.drawCard();
        }
    }
}
