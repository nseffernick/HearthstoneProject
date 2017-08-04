package Game.Auras;

import Cards.Structure.Minion;
import Utility.Tribes.Tribe;

public class MurlocWarleaderAura extends Aura{

    //TODO this
    public MurlocWarleaderAura(Minion link, String name) {
        super(link, name);
        this.adjacent = false;
        this.tribe = Tribe.MURLOC;
        this.where = "Friendly Board";
        this.effect = "Attack +2 Health +1";
    }

}