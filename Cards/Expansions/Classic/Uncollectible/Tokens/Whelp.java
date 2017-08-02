package Cards.Expansions.Classic.Uncollectible.Tokens;

import Cards.Structure.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Whelp  extends Minion {

    // State
    public int hp;
    public int atk;
    public int cost;
    public String name;
    private String text;
    private ArrayList<Keywords> properties;

    public Whelp(Player owner) {

        super(1, 1, 1, "Whelp", owner,"", Rarity.BASIC,
                Tribe.DRAGON, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }
}