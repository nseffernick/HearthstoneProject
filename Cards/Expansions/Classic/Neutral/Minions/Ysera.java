package Cards.Expansions.Classic.Neutral.Minions;

import Cards.Expansions.Classic.Uncollectible.Spells.Dream;
import Cards.Expansions.Classic.Uncollectible.Spells.Nightmare;
import Cards.Expansions.Classic.Uncollectible.Spells.YseraAwakens;
import Cards.Expansions.Classic.Uncollectible.Tokens.EmeraldDrake;
import Cards.Expansions.Classic.Uncollectible.Tokens.LaughingSister;
import Cards.Structure.Minion;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Keywords.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class Ysera extends Minion {

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

    public Ysera(Player owner) {

        super(12, 4, 9, "Ysera", owner,"At the end of your turn, add a Dream Card to your hand.", Rarity.LEGENDARY,
                Tribe.DRAGON, HeroClass.NEUTRAL, new ArrayList<Keywords>());
        properties.add(Keywords.ENDOFYOURTURN);
    }

    @Override
    public void endOfYourTurn(BoardState board) {
        if (properties.contains(Keywords.ENDOFYOURTURN)) {
            int dreamCard = owner.getRng().randomNum(5);
            if (dreamCard == 0) {
                EmeraldDrake emeraldDrake = new EmeraldDrake(owner);
            }
            if (dreamCard == 1) {
                LaughingSister laughingSister = new LaughingSister(owner);
            }
            if (dreamCard == 2) {
                Dream dream = new Dream(owner);
            }
            if (dreamCard == 3) {
                Nightmare nightmare = new Nightmare(owner);
            }
            if (dreamCard == 4) {
                YseraAwakens yseraAwakens = new YseraAwakens(owner);
            }
        }
    }
}
