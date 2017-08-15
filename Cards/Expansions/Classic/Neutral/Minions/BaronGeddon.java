package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.BaronGeddonAoE;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class BaronGeddon extends Minion {

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


    public BaronGeddon(Player owner) {

        super(5, 7, 7, "Baron Geddon", owner,"At the end of your turn, deal 2 damage to ALL other characters.", Rarity.LEGENDARY,
                Tribe.ELEMENTAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new BaronGeddonAoE(this));
    }

    //TODO change like everything to damaging instead of addHP Damaging.damageCharacter(UtilityMethods.findEnemy(board, owner), index, 1, board);
}