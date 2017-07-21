package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class FrostwolfWarlord extends Minion {
    // State
    public int hp = 4;
    public int atk = 4;
    public int cost = 5;
    public String name = "Frostwolf Warlord";
    private String text = "";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.GENERAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public FrostwolfWarlord(Player owner) {

        super(4, 4, 5, "Frostwolf Warlord", owner,"", Rarity.BASIC,
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

    public void battlecry(BoardState board) {
        if (properties.contains(Keywords.BATTLECRY)) {
            int set = board.findEnemy(owner).getPlayerSide().size();
            addAtk(set);
            addMaxHP(set);
            addHp(set);
        }
    }
}