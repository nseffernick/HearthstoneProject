package Cards.Expansions.Classic.Druid.Minions;

import Cards.Expansions.Classic.Uncollectible.Druid.Minions.BearForm;
import Cards.Expansions.Classic.Uncollectible.Druid.Minions.CatForm;
import Cards.Structure.ChooseOne;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Enchantments.Text.AttackBuff;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class DruidOfTheClaw extends Minion implements ChooseOne {

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


    public DruidOfTheClaw(Player owner) {

        super(4, 4, 5, "Druid of the Claw", owner, "Choose One: Transform into a 4/4 with Charge; or a 4/6 with Taunt.",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.DRUID, new ArrayList<Enchantments>());
    }

    @Override
    public boolean presentChoice(BoardState board) {
        System.out.println("Choose One:\n(1)Transform into a 4/4 with Charge;\n  --OR--\n(2)Transform to a 4/6 with Taunt.");
        String answer = owner.getPlayerInput().next("1|2|cancel");
        switch (answer) {
            case "1":
                owner.transform(this, new CatForm(owner));
                return true;
            case "2":
                owner.transform(this, new BearForm(owner));
                return true;
            case "cancel":
                return false;
        }
        return false;
    }

    //@Override
    //public void fandralInteratction(BoardState board) {}

}