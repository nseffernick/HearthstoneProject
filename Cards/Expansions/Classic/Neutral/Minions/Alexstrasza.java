package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.AttackAndTargetBehaviors.Targeting.TargetType;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Alexstrasza extends Minion {

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

    public Alexstrasza(Player owner) {

        super(8, 8, 9, "Alexstrasza", owner,"Set a hero's health to 15.", Rarity.LEGENDARY,
                Tribe.DRAGON, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        Player targetPlayer = owner.promptTargetPlayer(board, TargetType.ANY);
        if (targetPlayer.getHero().getMaxHP() < 15) {
            targetPlayer.getHero().setMaxHP(15);
        }
        int dmg = targetPlayer.getHero().getHp() - 15;
        MasterTargeter.Main(dmg, null, true, targetPlayer.getHero());
    }
}
