package player;

import team.TeamDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerService {

    private PlayerDAO playerDAO;
    private TeamDAO teamDAO;

    public PlayerService(PlayerDAO playerDAO, TeamDAO teamDAO) {
        this.playerDAO = playerDAO;
        this.teamDAO = teamDAO;
    }

    public void displayAllPlayers(){
        for (Player p : playerDAO.readFile()) {
            System.out.println(p.toStringStyle());
        }
    }

    public List<Player> findPlayersByFirstName(String name){
        List<Player> result = new ArrayList<>();
        for (Player p : playerDAO.getAllPlayers()) {
           String[] firstAndLast =  p.getName().split(" ");
           if (name.trim().equalsIgnoreCase(firstAndLast[0].trim())){
               result.add(p);
           }
        }
        System.out.println("player.Player(s) found:");
        return result.size() > 0 ? result : null;
    }
    public List<Player> findPlayersByLastName(String name){
        List<Player> result = new ArrayList<>();
        for (Player p : playerDAO.getAllPlayers()) {
            String[] firstAndLast =  p.getName().split(" ");
            if (name.trim().equalsIgnoreCase(firstAndLast[firstAndLast.length - 1].trim())){
                result.add(p);
            }
        }
        System.out.println("player.Player(s) found:");
        return result.size() > 0 ? result : null;
    }

    public Player findPlayerByFullName(String name){
        for (Player p : playerDAO.getAllPlayers()) {
            if (name.trim().equalsIgnoreCase(p.getName().trim())){
                return p;
            }
        }
        return null;
    }
    public void createANewPlayer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name?");
        String name = scanner.nextLine();

        System.out.println("Position?");
        String position = scanner.nextLine();

        System.out.println("Shirt number?");
        int shirtNum = scanner.nextInt();

        System.out.println("Time of contract expiration:\nYear?");
        int year = scanner.nextInt();
        System.out.println("Month?");
        int month = scanner.nextInt();
        System.out.println("Day?");
        int day = scanner.nextInt();

        Player player = new Player(name, position, shirtNum, LocalDate.of(year,month,day));

        playerDAO.savePlayerToFile(player);

    }
}
