package Cards.Expansions.Classic.Druid.Spells;

import Cards.Structure.ChooseOne;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Enchantments.Keywords.HasTaunt;
import Utility.Enchantments.Enchantments.Text.AttackBuff;
import Utility.Enchantments.Enchantments.Text.HealthBuff;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;

public class MarkOfNature extends Spell implements ChooseOne{

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;

    public MarkOfNature(Player owner) {

        super(0, "Innervate", "Give yourself two mana this turn.", owner,
                Rarity.BASIC, HeroClass.DRUID);
    }

    @Override
    public void castSpell(BoardState board) {
        owner.addMana(2);
    }

    @Override
    public boolean presentChoice(BoardState board) {
        System.out.println("Choose One:\n(1) Gain 4 Attack\n  --OR--\n(2) Gain 4 Health and Taunt");
        String answer = owner.getPlayerInput().next("1|2|cancel");
        switch (answer) {
            case "1":
                Minion minion = owner.promptAMinion(board, 3);
                minion.getEnchantments().add(new AttackBuff(minion, 4));
                return true;
            case "2":
                Minion minion1 = owner.promptAMinion(board, 0);
                minion1.getEnchantments().add(new HasTaunt(minion1));
                minion1.getEnchantments().add(new HealthBuff(minion1, 4));
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