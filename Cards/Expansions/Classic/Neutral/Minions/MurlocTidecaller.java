package Cards.Expansions.Classic.Neutral.Minions;

import Game.CanHaveEnchantments;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Game.BoardState;
import Game.Player.Player;
import Utility.Enchantments.Structure.Enchantments;
import Utility.HeroClasses.HeroClass;
import Utility.Enchantments.Structure.Keywords;
import Utility.Rarities.Rarity;
import Utility.Tribes.Tribe;

import java.util.ArrayList;

public class MurlocTidecaller extends Minion {

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

    public MurlocTidecaller(Player owner) {

        super(2, 1, 1, "Murloc Tidecaller", owner,"Whenever you summon a Murloc, gain +1 Attack.", Rarity.RARE,
                Tribe.MURLOC, HeroClass.NEUTRAL, new ArrayList<Enchantments>());
        enchantments.add(new MurlocTidecallerText(this));
    }

    private class MurlocTidecallerText extends Enchantments {

        private int murlocs;

        private MurlocTidecallerText(CanHaveEnchantments link) {
            super(Keywords.MINIONSUMMONED, "", link);
            murlocs = 0;
        }

        @Override
        public void enchant(BoardState board, Minion minion, Spell spell) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                if (minion.getTribe() == Tribe.MURLOC) {
                    minionLink.addAtk(1);
                    murlocs += 1;
                }
            }
        }

        @Override
        public void disenchant(BoardState board, Minion minion) {
            if (link instanceof Minion) {
                Minion minionLink = (Minion) link;
                minionLink.addAtk(-murlocs);
            }
        }
    }
}