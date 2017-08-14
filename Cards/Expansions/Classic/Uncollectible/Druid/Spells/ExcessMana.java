package Cards.Expansions.Classic.Uncollectible.Druid.Spells;

import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;

import java.util.ArrayList;

public class ExcessMana extends Spell {


    public ExcessMana(int cost, String name, String text, Player owner, Rarity rarity, HeroClass heroClass, ArrayList<Keywords> properties) {
        super(cost, name, text, owner, rarity, heroClass, properties);
    }

    @Override
    public void castSpell(BoardState board) {

    }
}
