package scoreboard.oops;

import java.util.ArrayList;
import scoreboard.model.Player;

public interface PlayerInterface {
    void addNewPlayer(Player playe);
    void printPlayers();
    void clearPlayerList();
    ArrayList<Player> playerData();
}
