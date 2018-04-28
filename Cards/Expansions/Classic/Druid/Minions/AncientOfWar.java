package Cards.Expansions.Classic.Druid.Minions;

import Cards.Structure.ChooseOne;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Enchantments.Text.AttackBuff;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class AncientOfWar extends Minion implements ChooseOne {

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


    public AncientOfWar(Player owner) {

        super(5, 5, 7, "Ancient of War", owner, "Choose One: +5 Attack --OR-- +5 Health and Gain Taunt",
                Rarity.EPIC, Tribe.GENERAL, HeroClass.DRUID, new ArrayList<Enchantments>());
    }

    @Override
    public boolean presentChoice(BoardState board) {
        System.out.println("Choose One:\n(1)Uproot: +5 Attack\n  --OR--\n(2)Rooted: +5 Health and Gain Taunt");
        String answer = owner.getPlayerInput().next("1|2|cancel");
        switch (answer) {
            case "1":
                enchantments.add(new AttackBuff(this, 5));
                return true;
            case "2":
                enchantments.add(new HasTaunt(this));
                return true;
            case "cancel":
                return false;
        }
        return false;
    }

    //@Override
    //public void fandralInteratction(BoardState board) {}

}
