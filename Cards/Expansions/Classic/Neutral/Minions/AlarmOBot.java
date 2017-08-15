package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Card;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.AlarmText;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

//TODO need to implement some sort of refresh method on cards
public class AlarmOBot extends Minion {

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

    public AlarmOBot(Player owner) {

        super(3, 0, 3, "Alarm-o-Bot", owner,"At the start of your turn, swap this minion with one in your hand.", Rarity.RARE,
                Tribe.MECH, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new AlarmText(this));
    }


}