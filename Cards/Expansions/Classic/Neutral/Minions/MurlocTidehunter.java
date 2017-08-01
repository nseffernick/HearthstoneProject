package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Tokens.MurlocScout;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

/**
 * Created by Cheech on 4/10/2017.
 */
public class MurlocTidehunter extends Minion {

    // State
    protected int hp = 1;
    protected int atk = 2;
    protected int cost = 2;
    protected String name = "Murloc Tidehunter";
    protected String text = "Battlecry: Summon a 1/1 Murloc";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.MURLOC;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public MurlocTidehunter(Player owner) {

        super(1, 2, 2, "Murloc Tidehunter", owner,
                "Battlecry: Summon a 1/1 Murloc", Rarity.BASIC,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.BATTLECRY);
    }

    // Summon a 1/1 murloc
    public void battlecry(BoardState board, Player player, int index) {
        if (properties.contains(Keywords.BATTLECRY)) {
            owner.summonCard(new MurlocScout(owner), board);
        }
    }
}
