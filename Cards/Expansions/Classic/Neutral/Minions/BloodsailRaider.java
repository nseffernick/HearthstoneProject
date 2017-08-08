package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class BloodsailRaider extends Minion {

    // State
    protected int hp;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Keywords> properties;


    public BloodsailRaider(Player owner) {

        super(3, 2, 2, "Bloodsail Raider", owner, "Battlecry: Battlecry: Gain Attack equal to the Attack" +
                        "of your weapon.", Rarity.COMMON, Tribe.PIRATE, HeroClass.NEUTRAL,
                new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (properties.contains(Keywords.BATTLECRY)) {
            if (owner.getHero().getWeapon() != null) {
                int atkIncrease = owner.getHero().getWeapon().getAtk();
                addAtk(atkIncrease);
            }
        }
    }
}