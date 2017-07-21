package Cards.Classic.Uncollectible.Tokens;

import Cards.Minion;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 6/26/2017.
 */
public class MurlocScout extends Minion {

    // State
    public int hp = 1;
    public int atk = 1;
    public int cost = 1;
    public String name = "Murloc Scout";
    private String text = "";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public MurlocScout(Player owner) {

        super(1, 1, 1, "Murloc Scout", owner,"", Rarity.BASIC,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }
}
