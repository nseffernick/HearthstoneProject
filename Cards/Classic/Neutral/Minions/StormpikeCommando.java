package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/11/2017.
 */
public class StormpikeCommando extends Minion {
    // State
    public int hp = 2;
    public int atk = 4;
    public int cost = 5;
    public String name = "Stormpike Commando";
    private String text = "Battlecry: Deal 2 damage";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.GENERAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public StormpikeCommando(Player owner) {

        super(2, 4, 5, "Stormpike Commando", owner,
                "Battlecry: Deal 2 damage", Rarity.BASIC,
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
    // Deal two damage
    public void battlecry(Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            MasterTargeter.Main(player, index, 2, null);
        }
    }
}
