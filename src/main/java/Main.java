import player.Player;
import player.PlayerDAO;
import player.PlayerService;
import team.TeamDAO;
import team.TeamService;

public class Main {
    public static void main(String[] args) {

        PlayerDAO playerDAO = new PlayerDAO();
        TeamDAO teamDAO = new TeamDAO();
        PlayerService playerService = new PlayerService(playerDAO, teamDAO);
        TeamService teamService = new TeamService(playerDAO, teamDAO);

        for (Player p : playerDAO.getAllPlayers()) {
            System.out.println(p.toStringCSV());
        }

        System.out.println("---------------");

        playerService.findPlayerByFullName("Jonny wilkinson").wantsToExtendContract(2);
        playerService.findPlayerByFullName("Carlin isles").wantsToSwapShirts(3);




    }
}
