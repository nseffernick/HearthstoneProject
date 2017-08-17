package Cards.Expansions.Classic.Druid.Spells;

import Cards.Expansions.Classic.Uncollectible.Druid.Spells.ExcessMana;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;

public class WildGrowth extends Spell {

    //State
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;

    public WildGrowth(Player owner) {

        super(2, "Innervate", "Give yourself an empty mana crystal", owner,
                Rarity.BASIC, HeroClass.DRUID);
    }

    @Override
    public void castSpell(BoardState board) {
        if (owner.getManaCrystals() == 10) {
            if (owner.getHand().size() < 10) {
                owner.getHand().add(new ExcessMana(owner));
            }
        }
        else {
            owner.addManaCrystals(1);
        }
    }
}
