package Cards.Expansions.Classic.Druid.Minions;

import Cards.Structure.ChooseOne;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.AttackAndTargetBehaviors.MasterTargeter;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class AncientOfLore extends Minion implements ChooseOne{

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


    public AncientOfLore(Player owner) {

        super(5, 5, 7, "Ancient of Lore", owner,"Choose One: Draw a card or restore 5 health",
                Rarity.EPIC, Tribe.GENERAL, HeroClass.DRUID, new ArrayList<Enchantments>());
    }

    @Override
    public boolean presentChoice(BoardState board) {
        System.out.println("Choose One:\n(1)Ancient Secrets: Draw a Card\n --OR--\n(2)Ancient Teachings: Restore 5 health" );
        String answer = owner.getPlayerInput().next("1|2|cancel");
        switch (answer) {
            case "1":
                owner.drawCard();
                return true;
            case "2":
                Player player = owner.promptTargetPlayer(board, );
                int index = owner.promptTargetIndex(board, );
                MasterTargeter.Main(player, index, -5, null, false, board);
                return true;
            case "cancel":
                return false;
        }
        return false;
    }

    /*
    @Override
    public void fandralInteratction(BoardState board) {

    }
    */
}