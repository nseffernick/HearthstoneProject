/**
 * ME 3/19/17
 */
public abstract class Minion extends Card{

    // State
    private int hp;
    private int atk;
    private int cost;
    private String name;
    private String text;
    private String rarity;
    private ArrayList<Property> properties;

    public Minion(int hp, int atk, int cost, String name, String text,
                String rarity, ArrayList properties) {

        this.atk = atk;
        this.hp = hp;
        this.cost = cost;
        this.name = name;
        this.text = text;
        this.rarity = rarity;

        this.properties = properties
    }

    public boolean combatSickness(int turnsPast) {

    }

    public boolean canTarget(int atk) {

    }

    public boolean isDead(int hp) {

    }

    public boolean canPlay(int cost, int mana) {

    }




