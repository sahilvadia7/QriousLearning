package scoreboard.controller;

import java.util.ArrayList;
import java.util.Scanner;
import scoreboard.model.*;
import scoreboard.model.Player;
import scoreboard.service.MatchService;
import scoreboard.service.PlayerService;
import scoreboard.service.TeamService;

public class ScoreBoard {

    static Scanner input = new Scanner(System.in);
    static PlayerService playerService = new PlayerService();
    static TeamService teamService = new TeamService();

    static Team newTeam = new Team();
    static Player p1;

    public static void main(String[] args) {
        matchInfo();
    }

    public static void PlayerFun() {
        System.out.print("How many player want to add? :");
        int no = input.nextInt();
        for (int i = 0; i < no; i++) {
            p1 = new Player();
            System.out.print("Enter ID :");
            p1.setId(input.nextInt());

            System.out.print("Enter Name :");
            p1.setName(input.next());

            System.out.println("Role");
            for (Role r : Role.values()) {
                System.out.print(r + ",");
            }

            System.out.println();
            System.out.print("Enter Role: ");
            String roleInput = input.next();

            try {
                Role selectedRole = Role.fromString(roleInput);
                p1.setRole(selectedRole);
                // System.out.println(
                //     "Role set to: " + selectedRole.getRoleName()
                // );
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid role! Please enter a valid role.");
            }

            System.out.print("Enter Date of Join :");
            p1.setYear(input.next());
            playerService.addNewPlayer(p1);
        }
        // playerService.printPlayers();
    }

    public static void TeamFun() {
        System.out.print("How many team want to add? :");
        int no = input.nextInt();
        for (int i = 0; i < no; i++) {
            newTeam = new Team();

            System.out.print("Enter TeamId :");
            newTeam.setId(input.nextInt());

            System.out.print("Enter Name :");
            newTeam.setName(input.next());
            PlayerFun();

            newTeam.setPlayers(playerService.playerData());

            // teamService.addTeam(newTeam); old
            // teamService.addPlyaerWithTeamTag(newTeam.getId(), p1);

            teamService.addPlyaerWithTeamTag(
                newTeam,
                new ArrayList<>(playerService.playerData())
            );

            playerService.clearPlayerList();
            // System.out.println("\nTeamData"); old
            // teamService.PrintTeamData(); //old

            System.out.println("\n\n Team With Player");
            teamService.pTeamDataWithPlayer();
        }
    }

    public static void matchInfo() {
        MatchService ms = new MatchService();
        ms.NewMatch();
        ms.MatchInfo();
    }
}
