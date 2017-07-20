package Game.Auras;

import Cards.Minion;
import Utility.Tribes.Tribe;

/**
 * Created by Cheech on 6/26/2017.
 */
public class StormwindChampionAura extends Aura{

    public StormwindChampionAura(Minion link, String name) {
        super(link, name);
        this.adjacent = false;
        this.tribe = null;
        this.where = "Friendly Board";
        this.effect = "Attack/Health +1";
    }
}
