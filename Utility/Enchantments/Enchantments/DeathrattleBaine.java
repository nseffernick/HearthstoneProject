package Utility.Enchantments.Enchantments;

import Cards.Expansions.Classic.Uncollectible.Neutral.Minions.BaineBloodhoof;
import Cards.Structure.Minion;
import Game.BoardState;
import Utility.Enchantments.Structure.Enchantments;
import Utility.Enchantments.Structure.Keywords;

public class DeathrattleBaine extends Enchantments {

    public DeathrattleBaine(Minion link) {
        super(Keywords.DEATHRATTLE, "Deathrattle: Summon Baine", link);
    }

    @Override
    protected void enchant(BoardState board, Minion minion) {
        minion.getOwner().summonMinion(new BaineBloodhoof(minion.getOwner()), board);
    }

    @Override
    protected void disenchant(BoardState board, Minion minion) {
    }
}