package scoreboard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import scoreboard.controller.ScoreBoard;
import scoreboard.model.Match;
import scoreboard.model.Player;
import scoreboard.model.Team;
import scoreboard.oops.MatchInterface;

public class MatchService implements MatchInterface {

    private final Scanner scanner = new Scanner(System.in);
    static TeamService teamS = new TeamService();
    public static int matchIds = 1;
    static Match match;

    @Override
    public void MatchInfo() {
        System.out.println("Welcome to Scoreboard");
        displayMatchDetails(match);
    }

    @Override
    public void NewMatch() {
        // System.out.print("Enter Match ID:");
        int matchId = matchIds;
        matchIds++;
        ScoreBoard.TeamFun();

        // scanner.nextLine();
        System.out.print("Enter Match Result:");
        String matchType = scanner.next();

        scanner.nextLine();
        System.out.print("Enter Match Type:");
        String result = scanner.next();

        System.out.print("Enter Match Score:");
        int score = scanner.nextInt();

        List<String> teamToplay = teamS.teamsToPlay;
        System.out.println(teamToplay);
        match = new Match(matchId, matchType, teamToplay, result, score);
        // displayMatchDetails(match);
    }

    @Override
    public void TeamDetails() {
        Map<Team, ArrayList<Player>> teamL = teamS.playersT;
        System.out.println("\n\n Team With Player");
        System.out.println(teamL);
        TeamService teamService = new TeamService();
        teamService.pTeamDataWithPlayer();
        // System.out.println("Team details feature coming soon...");
    }

    private void displayMatchDetails(Match match) {
        System.out.println("\n=== Match Details ===");
        System.out.println("Match ID: " + match.getId());
        System.out.println("Match Type: " + match.getType());

        System.out.print("Teams: ");
        int count = 0;
        System.out.println(match.getTeams());
        for (String team : match.getTeams()) {
            System.out.print(team);
            if (count == 0) {
                System.out.print(" vs ");
            }
            count++;
        }

        System.out.println("\nResult: " + match.getResult());
        System.out.println("Score: " + match.getScore());
        // TeamDetails();
    }
}
