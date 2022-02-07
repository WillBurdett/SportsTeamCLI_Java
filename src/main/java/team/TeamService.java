package team;

import player.Player;
import player.PlayerDAO;

import java.util.Scanner;

public class TeamService {
    private PlayerDAO playerDAO;
    private TeamDAO teamDAO;

    public TeamService(PlayerDAO playerDAO, TeamDAO teamDAO) {
        this.playerDAO = playerDAO;
        this.teamDAO = teamDAO;
    }

    public Team findTeamByName(String name){
        for (Team t : teamDAO.getAllTeams()){
            if (name.trim().equalsIgnoreCase(t.getName().trim())){
                return t;
            }
        }
        return null;
    }

    public int numOfSpacesAvailableInTeam(Team team){
        int count = 0;
        for (Player player : team.getPlayers()) {
            if (player == null){
                count++;
            }
        }
        return count;
    }

    public void addPlayerToTeam(){
        System.out.println("Select a team to add a player to:");
        int option = 1;
        for (Team t : teamDAO.getAllTeams()) {
            System.out.println(option++ + ". " + t.getName());
        }

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Team team = teamDAO.getAllTeams().get(input - 1);
        if (team == null){
            System.out.println("Team could not be found. Please try again.");
            addPlayerToTeam();
        }
        System.out.println("Please select a player:");
        int choice = 1;
        for (Player player : playerDAO.readFile()) {
            System.out.println(choice++ + ". " + player.toStringStyle());
        }
        int name = scanner.nextInt();
        Player player = playerDAO.readFile()[name - 1];
        if (player == null){
            System.out.println("Player could not be found. Please try again.");
            addPlayerToTeam();
        }

        for (int i = 0; i < team.getPlayers().length; i++) {
            if (team.getPlayers()[i] == null){
                team.getPlayers()[i] = player;
                break;
            }
        }

        System.out.println(team);


    }
}
