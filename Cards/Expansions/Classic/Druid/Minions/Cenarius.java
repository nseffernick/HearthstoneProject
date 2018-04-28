package Cards.Expansions.Classic.Druid.Minions;

import Cards.Expansions.Classic.Uncollectible.Druid.Minions.Treant;
import Cards.Structure.ChooseOne;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Enchantments.Text.AttackHealthBuff;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Cenarius extends Minion implements ChooseOne {

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


    public Cenarius(Player owner) {

        super(8, 5, 7, "Cenarius", owner, "Choose One: Give +2/+2 to all friendly minions --OR-- Summon 2 2/2 Treants with Taunt",
                Rarity.EPIC, Tribe.GENERAL, HeroClass.DRUID, new ArrayList<Enchantments>());
    }

    @Override
    public boolean presentChoice(BoardState board) {
        System.out.println("Choose One:\n(1)Demigod's Favor: Give +2/+2 to all friendly minions\n --OR--\n(2)Shan'do's Lesson Summon 2 2/2 Treants with Taunt");
        String answer = owner.getPlayerInput().next("1|2|cancel");
        switch (answer) {
            case "1":
                for (Minion minion: owner.getPlayerSide()) {
                    if (minion == this);
                    else {
                        enchantments.add(new AttackHealthBuff(minion, 2, 2));
                    }
                }
                return true;
            case "2":
                Minion newTreant1 = new Treant(owner);
                Minion newTreant2 = new Treant(owner);
                newTreant1.getEnchantments().add(new HasTaunt(newTreant1));
                newTreant2.getEnchantments().add(new HasTaunt(newTreant2));
                owner.summonMinion(newTreant1, board);
                owner.summonMinion(newTreant2, board);
                return true;
            case "cancel":
                return false;
        }
        return false;
    }

    //@Override
    //public void fandralInteratction(BoardState board) {}

}