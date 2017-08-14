package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class FrostElemental extends Minion {

    // State
    protected int hp = 2;
    protected int atk = 2;
    protected int cost = 3;
    protected String name = "Ironforge Rifleman";
    protected String text = "Battlecry: Deal one damage";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<Utility.Enchantments.Structure.Enchantments>();

    public FrostElemental(Player owner) {

        super(5, 5, 6, "Frost Elemental", owner,
                "Battlecry: Freeze a character", Rarity.COMMON,
                Tribe.ELEMENTAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (properties.contains(Keywords.BATTLECRY)) {
            Player playerTarget = null;
            int index = -2;
            while (1 == 1) {
                playerTarget = owner.promptTargetPlayer(board);
                index = owner.promptTargetIndex(board, 0);
                if (Targeting.characterTargeting(playerTarget, index, true)) {
                    break;
                }
            }
            if (index == -1) {
                playerTarget.getHero().getProperties().add(Keywords.FREEZE);
            }
            else {
                playerTarget.getPlayerSide().get(index).getEnchantments().add(Keywords.FREEZE);
            }
        }
    }
}
