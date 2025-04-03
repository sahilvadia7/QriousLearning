// package scoreboard.impl;

// import java.util.Scanner;
// import scoreboard.model.Player;
// import scoreboard.model.Role;
// import scoreboard.service.PlayerService;

// public class PlayerImlp {

//     static Scanner input = new Scanner(System.in);
//     static PlayerService playerService = new PlayerService();
//     static Player p1;

//     public static void PlayerFun() {
//         System.out.print("How many player want to add? :");
//         int no = input.nextInt();
//         for (int i = 0; i < no; i++) {
//             p1 = new Player();
//             System.out.print("Enter ID :");
//             p1.setId(input.nextInt());

//             System.out.print("Enter Name :");
//             p1.setName(input.next());

//             System.out.println("Role");
//             for (Role r : Role.values()) {
//                 System.out.print(r + ",");
//             }

//             System.out.println();
//             System.out.print("Enter Role: ");
//             String roleInput = input.next();

//             try {
//                 Role selectedRole = Role.fromString(roleInput);
//                 p1.setRole(selectedRole);
//                 // System.out.println(
//                 //     "Role set to: " + selectedRole.getRoleName()
//                 // );
//             } catch (IllegalArgumentException e) {
//                 System.out.println("Invalid role! Please enter a valid role.");
//             }

//             System.out.print("Enter Date of Join :");
//             p1.setYear(input.next());
//             playerService.addNewPlayer(p1);
//         }
//         // playerService.printPlayers();
//     }
// }
