package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class BloodsailCorsair extends Minion {

    // State
    protected int hp;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Enchantments> enchantments;


    public BloodsailCorsair(Player owner) {
        super(2, 1, 1, "Bloodsail Corsair", owner,
                "Battlecry: Remove\n1 Durability from your\nopponent's weapon.", Rarity.RARE,
                Tribe.PIRATE, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    /**
     * Damage an opponent's weapon
     */
    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (!(UtilityMethods.findEnemy(board, owner).getHero().getWeapon() == null)) {
            UtilityMethods.findEnemy(board, owner).getHero().getWeapon().addDurability(-1);
        }
    }
}