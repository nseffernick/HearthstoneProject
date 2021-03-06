package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Cards.Structure.Weapon;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class HarrisonJones extends Minion {

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

    public HarrisonJones(Player owner) {

        super(4, 5, 5, "Harrison Jones", owner,
                "Battlecry: Destroy the opponent's weapon and draw cards equal to its durability",
                Rarity.LEGENDARY, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    /**
     * Destroy the opponent's weapon
     */
    @Override
    public void battlecry(BoardState board, Player player, int position) {
        Weapon weapon = UtilityMethods.findEnemy(board, owner).getHero().getWeapon();
        UtilityMethods.findEnemy(board, owner).getHero().setWeapon(null);
        if (weapon != null) {
            for (int i = 0; i >= weapon.getDurability(); i++) {
                owner.drawCard();
            }
        }
    }
}
