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

public class AncientBrewmaster extends Minion {

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

    public AncientBrewmaster(Player owner) {

        super(4, 5, 4, "Ancient Brewmaster", owner,"Battlecry: Return a friendly minion from the battlefield to your hand.",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        int index = owner.promptTargetIndex(board, );
        if (index == 10);
        else if (Targeting.characterTargeting(, owner, true)) {
            returnBackToHand(index, owner);
        }
    }
}
