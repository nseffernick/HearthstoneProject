package Cards.Expansions.Classic.Warlock.Minions;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/26/2017.
 */
public class Jaraxxus extends Minion {

    // State
    private int hp = 15;
    private int atk = 3;
    private int cost = 9;
    private String name = "Jaraxxus";
    private String text = "Battlecry: Destroy your hero and replace it with" +
            "Lord Jaraxxus";
    protected Rarity rarity = Rarity.LEGENDARY;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public Jaraxxus(Player player) {

        super(15, 3, 9, "Jaraxxus", player, "Battlecry: Destroy your hero and " +
                        "replace it with Lord Jaraxxus", Rarity.LEGENDARY,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<>());
    }
}