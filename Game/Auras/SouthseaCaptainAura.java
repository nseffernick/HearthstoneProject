package Game.Auras;

import Cards.Structure.Minion;
import Utility.Tribes.Tribe;

public class SouthseaCaptainAura extends Aura{

    public SouthseaCaptainAura(Minion link, String name) {
        super(link, name);
        this.adjacent = false;
        this.tribe = Tribe.PIRATE;
        this.where = "Friendly Board";
        this.effect = "Attack +1 Health +1";
    }
}

