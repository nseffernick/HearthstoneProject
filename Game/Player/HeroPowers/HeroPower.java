package Game.Player.HeroPowers;

import Game.Player.Player;

/**
 * ME 3/19/17
 */
public abstract class HeroPower {

    protected int cost;
    protected boolean wasCast;

    public HeroPower() {
        this.cost = 2;
        this.wasCast = false;
    }

    public int getCost() {
        return cost;
    }

    public boolean getWasCast() {
        return wasCast;
    }

    public abstract void Cast(Player player, int index);
    public boolean isExhausted() {
        return wasCast;
    };



    /*

    -----  Old code, Still usable just not in this way  -----


    // State
    int cost;
    private String name;
    private boolean castable;

    public HeroPower(String name) {
        initializeHeroPower(name);
    }


    private void initializeHeroPower(String name) {
        if (name.equals("Life Tap")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Lesser Heal")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Steady Shot")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Fireblast")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Armor Up")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Totemic Call")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Dagger Mastery")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Reinforce")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("Shapeshift")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("DIE, INSECT")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
        if (name.equals("INFERNO!")) {
            this.cost = 2;
            this.name = name;
            this.castable = true;
        }
    }


     * All the hero powers
     * Also still need to account for things like velen, justicar,
     * 2 mana 3/2 heropower damage +1
     * @param name
     * @param castable
     * @param player
     * @param target
     * @param index
    public void Cast(String name, boolean castable,
                     Player player, Player target, int index) {
        if (player.mana >= cost) {
            if (castable) {
                switch (name) {
                    case "Shapeshift": player.hero.atk += 1; player.hero.armor += 1;
                    case "Reinforce": player.summonCard(new SilverHand());
                    case "Dagger Mastery": player.hero.weapon = new WickedKnife();
                    case "Totemic Call": shamanHeroPowerRoll(player);
                    case "Fireblast": player.damageCharacter(target, index, 1);
                    case "Armor Up": player.hero.armor += 2;
                    case "Life Tap": player.hero.hp -= 2;
                    case "Steady Shot": player.damageCharacter(target, 0, 2);
                    case "Lesser Heal": player.damageCharacter(target, index, -2);
                    case "DIE, INSECT":;
                    case "INFERNO!": player.summonCard(new Infernal());
                }
                this.castable = false;
            }
        }
        System.out.println("Cannot cast Hero Power");
    }


    */

}