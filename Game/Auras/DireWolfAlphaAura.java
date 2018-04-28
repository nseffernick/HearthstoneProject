package Game.Auras;

import Cards.Structure.Minion;

public class DireWolfAlphaAura extends Aura{

    public DireWolfAlphaAura(Minion link, String name) {
        super(link, name);
        this.adjacent = true;
        this.tribe = null;
        this.where = "Friendly Board";
        this.effect = "Attack +1";
    }
}

