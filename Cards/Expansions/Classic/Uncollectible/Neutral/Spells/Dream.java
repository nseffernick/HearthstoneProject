package Cards.Expansions.Classic.Uncollectible.Neutral.Spells;

import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.HeroClasses.HeroClass;
import Utility.Rarities.Rarity;

public class Dream extends Spell{

    protected int cost;
    protected String name;
    protected String text;
    protected Rarity rarity;
    protected HeroClass heroClass;

    public Dream(Player owner) {

        super(0, "Dream", "Return a minion to it's owner's hand", owner,
                Rarity.BASIC, HeroClass.NEUTRAL);
    }

    @Override
    public void castSpell(BoardState board) {
        Player player = owner.promptTargetPlayer(board, );
        int index = owner.promptTargetIndex(board, );
        if (index == 10);
        else returnBackToHand(index, player);
    }

    @Override
    public boolean canPlay(BoardState board) {
        return super.canPlay(board) && !board.isBoardEmpty();
    }
}
