package scoreboard.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import scoreboard.model.Player;
import scoreboard.model.Team;

public class TeamService {

    // List<Team> teamD = new ArrayList<>();
    Map<Team, ArrayList<Player>> playersT = new HashMap<>();
    List<String> teamsToPlay = new ArrayList<>();

    PlayerService ps = new PlayerService();

    public void addPlyaerWithTeamTag(Team team, ArrayList<Player> player) {
        ArrayList<Player> teamPlayers = new ArrayList<>(player);
        teamsToPlay.add(team.getName());
        System.out.println(teamsToPlay);
        playersT.put(team, teamPlayers);
    }

    // public void addTeam(Team team) {
    //     teamD.add(team);
    // }

    // public void PrintTeamData() {
    //     teamD.stream().forEach(System.out::print);
    // }

    public Map<Team, ArrayList<Player>> RTeamDataWithPlayer() {
        return playersT;
    }

    public void pTeamDataWithPlayer() {
        for (Map.Entry<Team, ArrayList<Player>> me : playersT.entrySet()) {
            // Printing keys
            System.out.print(me.getKey() + " :");
            System.out.println(me.getValue());
        }
    }
}
