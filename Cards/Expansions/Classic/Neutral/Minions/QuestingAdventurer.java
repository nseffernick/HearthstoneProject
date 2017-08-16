package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;
//TODO TODO
public class QuestingAdventurer extends Minion {

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

    public QuestingAdventurer(Player owner) {

        super(2, 2, 3, "Questing Adventurer", owner,"Whenever you play a card, gain +1/+1.",
                Rarity.RARE, Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(Keywords.CARDPLAYED);
    }

    @Override
    public void cardPlayed(BoardState board) {
        if (properties.contains(Keywords.CARDPLAYED)) {
            addAtk(1);
            addMaxHP(1);
            addHp(1, board);
        }
    }
}