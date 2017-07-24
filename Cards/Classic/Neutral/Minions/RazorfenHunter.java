package Cards.Classic.Neutral.Minions;

import Cards.Classic.Uncollectible.Tokens.Boar;
import Cards.Classic.Uncollectible.Tokens.MurlocScout;
import Cards.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/11/2017.
 */
public class RazorfenHunter extends Minion {
    // State
    public int hp = 3;
    public int atk = 2;
    public int cost = 3;
    public String name = "Razorfen Hunter";
    private String text = "Battlecry: Summon a 1/1 Boar";
    private Rarity rarity = Rarity.BASIC;
    private Tribe tribe = Tribe.GENERAL;
    private HeroClass heroClass = HeroClass.NEUTRAL;
    private ArrayList<Keywords> properties = new ArrayList<>();

    public RazorfenHunter(Player owner) {

        super(3, 2, 3, "Razorfen Hunter", owner,
                "Battlecry: Summon a 1/1 Boar", Rarity.BASIC,
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

    // Summon a 1/1 boar
    public void battlecry(BoardState board, Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            owner.summonCard(new Boar(owner));
        }
    }
}