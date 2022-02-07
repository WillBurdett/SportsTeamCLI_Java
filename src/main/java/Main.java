import player.Player;
import player.PlayerDAO;
import player.PlayerService;
import team.TeamDAO;
import team.TeamService;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PlayerDAO playerDAO = new PlayerDAO();
        TeamDAO teamDAO = new TeamDAO();
        PlayerService playerService = new PlayerService(playerDAO, teamDAO);
        TeamService teamService = new TeamService(playerDAO, teamDAO);

        for (Player p : playerDAO.getAllPlayers()) {
            System.out.println(p.toStringCSV());
        }

        while(true) {

            System.out.println("Welcome! Please select an option:");
            System.out.println("1. Create a new player");
            System.out.println("2. Delete a player");
            System.out.println("3. Add a player to a team");
            System.out.println("4. Display all players");
            System.out.println("5. Exit program");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("'Create a new player' selected.");
                    playerService.createANewPlayer();

                    break;
                case 2:
                    System.out.println("'Delete a player' selected.");
                    break;
                case 3:
                    System.out.println("'Add a player to a team' selected.");
                    teamService.addPlayerToTeam();
                    break;
                case 4:
                    System.out.println("'Display all players' selected.");
                    playerService.displayAllPlayers();
                    break;
                case 5:
                    System.out.println("'Exit program' selected.\nGoodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }

        }





    }
}
