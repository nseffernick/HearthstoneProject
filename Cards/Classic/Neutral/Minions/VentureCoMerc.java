package Cards.Classic.Neutral.Minions;

import Cards.Minion;
import Game.Auras.Aura;
import Game.Auras.GrimscaleOracleAura;
import Game.BoardState;
import Game.Player.Player;
import Utility.UtilityMethods.UtilityMethods;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;
import Utility.Keywords.Keywords;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/21/2017. nxs1720@g.rit.edu
 *
 * VentureCo. was Really tricky for me in terms of raising the question of how
 * I want to design the project. I decided to make DELTACOST a Keyword despite
 * not specifically containing the phrase it will probably be useful in the
 * future. Brings up the question of how I will want to implement global
 * affects, will it call a function every turn, will I change a boolean value
 * when it comes into play, is killed, is bounced, etc...
 * Also decided to forgo the Property class, as I am just unsure how I would
 * implement it at the moment, so it will just have a ArrLst of Keywords that
 * will call certain methods given certain conditions, if they are present in
 * properties or not.
 * Also this debuff method (soon to be renamed) will probably not only
 * exist in this class, its also extremely cumbersome with the if
 * statements, switch cases doesn't really make sense, so idk.
 *
 */
public class VentureCoMerc extends Minion {

    // State
    protected int hp = 6;
    protected int atk = 7;
    protected int cost = 5;
    protected String name = "Venture Co. Mercenary";
    protected String text = "Your minions cost 3 more.";
    protected Rarity rarity = Rarity.BASIC;
    protected Tribe tribe = Tribe.GENERAL;
    protected HeroClass heroClass = HeroClass.NEUTRAL;
    protected ArrayList<Keywords> properties = new ArrayList<>();

    public VentureCoMerc(Player owner) {

        super(6, 7, 5, "Venture Co. Mercenary", owner,
                "Your minions cost 3 more.", Rarity.BASIC,
                Tribe.GENERAL, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.AURA);
    }

    public void createAura(BoardState board) {

        Aura thisAura = new GrimscaleOracleAura(this, "Grimscale Oracle Aura");
        owner.addAura(thisAura);
    }

}