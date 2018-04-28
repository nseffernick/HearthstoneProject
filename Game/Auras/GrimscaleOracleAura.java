package Game.Auras;

import Cards.Structure.Minion;
import Utility.Tribes.Tribe;

/**
 * Created by Cheech on 6/26/2017.
 */
public class GrimscaleOracleAura extends Aura{

    public GrimscaleOracleAura(Minion link, String name) {
        super(link, name);
        this.adjacent = false;
        this.tribe = Tribe.MURLOC;
        this.where = "Friendly Board";
        this.effect = "Attack +1";
    }

}
