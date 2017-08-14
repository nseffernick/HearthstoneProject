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

public class DarkIronDwarf extends Minion {

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

    public DarkIronDwarf(Player owner) {

        super(4, 4, 4, "Dark Iron Dwarf", owner,"Battlecry: Give a minion +2 Attack this turn.",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player, int position) {
        if (properties.contains(Keywords.BATTLECRY)) {
            int index = owner.promptTargetIndex(board, 3);
            if (index == 10);
            else if (Targeting.characterTargeting(owner, index, true)) {
                Minion minion = owner.getPlayerSide().get(index);
            }
        }
    }
}