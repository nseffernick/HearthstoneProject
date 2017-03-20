package Player;

/**
 * ME 3/19/17
 */
public class HeroPower {

    // State
    private int cost;
    private String name;
    private boolean castable;

    public HeroPower(int cost, String name) {
        this.cost = cost;
        this.name = name;
        this.castable = true;
    }


}