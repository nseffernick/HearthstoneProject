package Game.Player.HeroPowers;

import Game.Player.Player;
import Cards.Card;
import Cards.Classic.Uncollectible.Tokens.HeroPowerTotems.HealingTotem;
import Cards.Classic.Uncollectible.Tokens.HeroPowerTotems.SearingTotem;
import Cards.Classic.Uncollectible.Tokens.HeroPowerTotems.StoneclawTotem;
import Cards.Classic.Uncollectible.Tokens.HeroPowerTotems.WrathOfAir;
import Cards.Minion;

import java.util.ArrayList;

/**
 * Created by Cheech on 3/29/2017.
 */
public class TotemicCall extends HeroPower {

    public TotemicCall() {
        super();
    }

    @Override
    public void Cast(Player player, int index) {
        shamanHeroPowerRoll(player);
        wasCast = true;
    }

    private void shamanHeroPowerRoll(Player player) {
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
            player.summonCard(totem);
        }
    }

}
