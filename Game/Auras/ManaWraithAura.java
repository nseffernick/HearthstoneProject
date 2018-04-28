package Game.Auras;

import Cards.Structure.Minion;

public class ManaWraithAura extends Aura {

    public ManaWraithAura(Minion link, String name) {
        super(link, name);
        this.adjacent = false;
        this.tribe = null;
        this.where = "All Hand";
        this.effect = "Cost +1";
    }
}