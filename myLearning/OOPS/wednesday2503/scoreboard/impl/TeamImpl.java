// package scoreboard.impl;

// import java.util.ArrayList;
// import java.util.Scanner;
// import scoreboard.model.Player;
// import scoreboard.model.Team;
// import scoreboard.service.PlayerService;
// import scoreboard.service.TeamService;

// public class TeamImpl {

//     static Scanner input = new Scanner(System.in);
//     static PlayerService playerService = new PlayerService();
//     static TeamService teamService = new TeamService();

//     static Team newTeam = new Team();
//     static Player p1;

//     public static void TeamFun() {
//         System.out.print("How many team want to add? :");
//         int no = input.nextInt();
//         for (int i = 0; i < no; i++) {
//             newTeam = new Team();

//             System.out.print("Enter TeamId :");
//             newTeam.setId(input.nextInt());

//             System.out.print("Enter Name :");
//             newTeam.setName(input.next());
//             PlayerImlp.PlayerFun();

//             newTeam.setPlayers(playerService.playerData());

//             // teamService.addTeam(newTeam); old
//             // teamService.addPlyaerWithTeamTag(newTeam.getId(), p1);

//             teamService.addPlyaerWithTeamTag(
//                 newTeam,
//                 new ArrayList<>(playerService.playerData())
//             );

//             playerService.clearPlayerList();
//             // System.out.println("\nTeamData"); old
//             // teamService.PrintTeamData(); //old

//             System.out.println("\n\n Team With Player");
//             teamService.pTeamDataWithPlayer();
//         }
//     }
// }
