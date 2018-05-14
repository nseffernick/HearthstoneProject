package Game;

import Game.Player.Player;

public interface Targetable {

    int getAtk();

    int getHp();

    int getIndex();

    void addHp(int set);

    Player getOwner();
}
