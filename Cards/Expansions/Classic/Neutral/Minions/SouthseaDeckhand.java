package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Structure.Minion;
import Cards.Structure.Weapon;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class SouthseaDeckhand extends Minion {

    // State
    protected int hp;
    protected int atk;
    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected Tribe tribe;
    protected HeroClass heroClass;
    protected ArrayList<Keywords> properties;

    public SouthseaDeckhand(Player owner) {

        super(1, 2, 1, "Southsea Deckhand", owner,"Has Charge while you have a weapon equipped.",
                Rarity.COMMON, Tribe.PIRATE, HeroClass.NEUTRAL, new ArrayList<Keywords>());
    }

    @Override
    public void weaponPlayedProc(Weapon weapon, BoardState board) {
        if (owner.getHero().getWeapon() != null) {
            if (!properties.contains(Keywords.CHARGE)) {
                properties.add(Keywords.CHARGE);
            }
        }
        else {
            if (properties.contains(Keywords.CHARGE)) {
                properties.remove(Keywords.CHARGE);
            }
        }
    }
}