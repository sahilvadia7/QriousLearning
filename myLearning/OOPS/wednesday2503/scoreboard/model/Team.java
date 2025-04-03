package scoreboard.model;

import java.util.ArrayList;

// # team
// - id
// - name
// - Player<player>

public class Team {

    private int id;
    private String name;
    private ArrayList<Player> players;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "[id: " + id + ", Name :" + name + ", Player :" + players + "]";
    }
}
