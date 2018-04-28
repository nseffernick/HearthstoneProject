package Cards.Expansions.Classic.Druid.Minions;

import Cards.Structure.ChooseOne;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Game.Targetable;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class KeeperOfTheGrove extends Minion implements ChooseOne {

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


    public KeeperOfTheGrove(Player owner) {

        super(2, 2, 4, "Keeper Of The Grove", owner, "Choose One: Deal 2 Damage; Silence a Minion",
                Rarity.COMMON, Tribe.GENERAL, HeroClass.DRUID, new ArrayList<Enchantments>());
    }

    @Override
    //TODO Some kind of null checking for prompt a target maybe some boolean structure idk (me pretending im smart or something)
    public boolean presentChoice(BoardState board) {
        System.out.println("Choose One:\n(1)Deal 2 Damage\n  --OR--\n(2)Silence a Minion.");
        String answer = owner.getPlayerInput().next("1|2|cancel");
        switch (answer) {
            case "1":
                Targetable target = owner.promptAMinion(board, 0);
                target.addHp(-2);
                return true;
            case "2":
                Minion minion1 = owner.promptAMinion(board, 3);
                if (minion1 == null) return false;
                silence(minion1, board);
                return true;
            case "cancel":
                return false;
        }
        return false;
    }

    //@Override
    //public void fandralInteratction(BoardState board) {}

}