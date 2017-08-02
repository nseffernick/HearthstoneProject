package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
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
    protected ArrayList<Keywords> properties;

    public Alexstrasza(Player owner) {

        super(8, 8, 9, "Alexstrasza", owner,"Destroy every minion and discard every card in your hand", Rarity.LEGENDARY,
                Tribe.DRAGON, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player) {
        Player targetPlayer = owner.promptTargetPlayer(board);
        if (targetPlayer.getHero().getMaxHP() < 15) {
            targetPlayer.getHero().setMaxHP(15);
        }
        int dmg = targetPlayer.getHero().getHp() - 15;
        MasterTargeter.Main(targetPlayer, -1, dmg, null, true, board);
    }
}
