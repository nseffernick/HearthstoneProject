package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class CaptainGreenskin extends Minion {

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


    public CaptainGreenskin(Player owner) {

        super(4, 5, 5, "Captain Greenskin", owner,
                "Battlecry: Give your weapon +1/+1", Rarity.LEGENDARY,
                Tribe.PIRATE, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (owner.getHero().getWeapon() != null) {
            owner.getHero().getWeapon().addDurability(1);
            owner.getHero().getWeapon().addAtk(1);
        }
    }
}