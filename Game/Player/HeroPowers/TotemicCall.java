package Game.Player.HeroPowers;

import Game.BoardState;
import Game.Player.Player;
import Cards.Structure.Card;
import Cards.Expansions.Classic.Uncollectible.Shaman.Minions.HeroPowerTotems.HealingTotem;
import Cards.Expansions.Classic.Uncollectible.Shaman.Minions.HeroPowerTotems.SearingTotem;
import Cards.Expansions.Classic.Uncollectible.Shaman.Minions.HeroPowerTotems.StoneclawTotem;
import Cards.Expansions.Classic.Uncollectible.Shaman.Minions.HeroPowerTotems.WrathOfAir;
import Cards.Structure.Minion;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/29/2017.
 */
public class TotemicCall extends HeroPower {

    public TotemicCall(Player owner) {
        super(owner);
    }

    @Override
    public boolean Cast(Player player, BoardState board) {
        shamanHeroPowerRoll(player, board);
        wasCast = true;
        return true;
    }

    private void shamanHeroPowerRoll(Player player, BoardState board) {
        ArrayList<Minion> canSummon = new ArrayList<>();
        Minion heal = new HealingTotem(player);
        Minion taunt = new StoneclawTotem(player);
        Minion spell = new WrathOfAir(player);
        Minion searing = new SearingTotem(player);
        canSummon.add(heal);
        canSummon.add(taunt);
        canSummon.add(spell);
        canSummon.add(searing);
        for (Card boardSlot: player.getPlayerSide()) {
            if (boardSlot instanceof HealingTotem) {
                if (canSummon.contains(heal)) {
                    canSummon.remove(heal);
                }
            }
            if (boardSlot instanceof StoneclawTotem) {
                if (canSummon.contains(taunt)) {
                    canSummon.remove(taunt);
                }
            }
            if (boardSlot instanceof WrathOfAir) {
                if (canSummon.contains(spell)) {
                    canSummon.remove(spell);
                }
            }
            if (boardSlot instanceof SearingTotem) {
                if (canSummon.contains(searing)) {
                    canSummon.remove(searing);
                }
            }
        }
        if (!(canSummon.isEmpty())) {
            Minion totem = canSummon.get(player.getRng().randomNum
                    (canSummon.size()-1));
            player.summonMinion(totem, board);
        }
    }

    @Override
    public String toString() {
        return "Totemic Call - Summon a random Totem \nCost " + cost + " mana";
    }
}
