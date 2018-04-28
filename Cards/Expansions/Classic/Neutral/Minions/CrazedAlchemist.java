package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class CrazedAlchemist extends Minion {

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


    public CrazedAlchemist(Player owner) {

        super(2, 2, 2, "Crazed Alchemist", owner,
                "Battlecry: Swap a minion's health and attack", Rarity.RARE,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        Player targetPlayer;
        int index;
        while (1 == 1) {
            targetPlayer = owner.promptTargetPlayer(board, );
            index = owner.promptTargetIndex(board, );
            if (Targeting.characterTargeting(targetPlayer, index, true)) {
                break;
            }
        }
        Minion minion = targetPlayer.getPlayerSide().get(index);
        int atk = minion.getAtk();
        int health = minion.getHp();
        minion.setAtk(health);
        minion.setMaxHP(atk);
        minion.setHp(atk);
    }
}
