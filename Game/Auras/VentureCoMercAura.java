package Game.Auras;

import Cards.Minion;
import Utility.Tribes.Tribe;

/**
 * Created by Cheech on 6/26/2017.
 */
public class VentureCoMercAura extends Aura {

    public VentureCoMercAura(Minion link, String name) {
        super(link, name);
        this.adjacent = false;
        this.tribe = null;
        this.where = "Friendly Hand";
        this.effect = "Cost +3";
    }
}
