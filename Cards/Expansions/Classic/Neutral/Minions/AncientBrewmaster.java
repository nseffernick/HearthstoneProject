package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.Targeting.Targeting;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
    protected ArrayList<Keywords> properties;

    public AncientBrewmaster(Player owner) {

        super(4, 5, 4, "Ancient Brewmaster", owner,"Battlecry: Return a friendly minion from the battlefield to your hand.",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    @Override
    public void battlecry(BoardState board, Player player) {
        if (properties.contains(Keywords.BATTLECRY)) {
            int index = owner.promptTargetIndex(board, 2);
            if (index == 10);
            else if (Targeting.characterTargeting(owner, index, true)) {
                returnBackToHand(index);
            }
        }
    }

    private void returnBackToHand(int index) {
        Minion minion = owner.getPlayerSide().get(index);
        owner.getPlayerSide().remove(minion);
        Class newMinion = minion.getClass();
        try {
            Constructor constructor = newMinion.getConstructor(Player.class);
            Object card1 = constructor.newInstance(owner);
            if (card1 instanceof Minion) {
                Minion minion1 = (Minion) card1;
                owner.getHand().add(minion1);
            }
        }
        catch (InstantiationException | InvocationTargetException | IllegalAccessException |  NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
