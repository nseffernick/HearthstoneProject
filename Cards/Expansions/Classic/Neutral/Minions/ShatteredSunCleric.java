package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/11/2017.
 */
public class ShatteredSunCleric extends Minion {

    // State
    protected int hp = 2;
    protected int atk = 3;
    protected int cost = 3;
    protected String name = "Shattered Sun Cleric";
    protected String text = "Battlecry: Give a friendly minion +1/+1.";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public ShatteredSunCleric(Player owner) {

        super(2, 3, 3, "Shattered Sun Cleric", owner,
                "Battlecry: Give a friendly minion +1/+1", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    // Give +1/+1 to a friendly
    @Override
    public void battlecry(BoardState board, Player player) {
        
        if (properties.contains(Keywords.BATTLECRY)) {
            int index = player.promptTargetIndex(board, 2);
            if (index == 10);
            else if (Targeting.characterTargeting(owner, index, true)) {
                Minion minion = owner.getPlayerSide().get(index);
                minion.addAtk(1);
                minion.addMaxHP(1);
                minion.addHp(1, board);
            }
        }
    }
}