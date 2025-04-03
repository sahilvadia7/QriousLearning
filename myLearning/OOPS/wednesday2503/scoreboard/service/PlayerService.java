package scoreboard.service;

import java.util.ArrayList;
import scoreboard.model.Player;
import scoreboard.oops.*;

public class PlayerService implements PlayerInterface {

    ArrayList<Player> players = new ArrayList<>();

    // Map<Integer, ArrayList<Player>> playersT = new HashMap();

    @Override
    public void addNewPlayer(Player player) {
        players.add(player);
        // playersT.put(team.getId(), players);
    }

    @Override
    public void printPlayers() {
        players.stream().forEach(System.out::print);
    }

    @Override
    public void clearPlayerList() {
        players.clear();
    }

    @Override
    public ArrayList<Player> playerData() {
        return players;
    }
}
