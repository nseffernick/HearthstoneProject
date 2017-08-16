package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.Whelp;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasCharge;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.UtilityMethods.UtilityMethods;

import java.util.ArrayList;

public class LeeroyJenkins  extends Minion {

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

    public LeeroyJenkins(Player owner) {

        super(2, 6, 5, "Leeroy Jenkins", owner,"Charge. Summon 2 1/1 Whelp for your opponent.",
                Rarity.LEGENDARY, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new HasCharge(this));
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        UtilityMethods.findEnemy(board, owner).summonMinion(new Whelp(UtilityMethods.findEnemy(board, owner)), board);
        UtilityMethods.findEnemy(board, owner).summonMinion(new Whelp(UtilityMethods.findEnemy(board, owner)), board);
    }
}
