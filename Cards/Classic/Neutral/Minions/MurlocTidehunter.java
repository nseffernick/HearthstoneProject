package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class MurlocTidehunter extends Minion {
    // State
    public int hp = 1;
    public int atk = 2;
    public int cost = 2;
    public String name = "Murloc Tidehunter";
    private String text = "Battlecry: Summon a 1/1 Murloc";
    private ArrayList<Keywords> properties = new ArrayList<>();

    public MurlocTidehunter() {

        super(1, 2, 2, "Murloc Tidehunter",
                "Battlecry: Summon a 1/1 Murloc", Rarity.BASIC,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Keywords>());
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
}