package Game.Auras;

import Cards.Structure.Minion;
import Game.BoardState;

public class PintSizedSummonerAura extends Aura implements DisableableAura {

    //State
//TODO ASODASASDDAS ASAASD
    public boolean trigger;

    public PintSizedSummonerAura(Minion link, String name) {
        super(link, name);
        this.adjacent = false;
        this.tribe = null;
        this.where = "Friendly Hand";
        this.effect = "Cost -1";
        this.trigger = true;
    }

    @Override
    public void disableAura() {
        if (trigger) {

        }
    }

    @Override
    public void enableAura() {
        if (!trigger) {

        }
    }
}
