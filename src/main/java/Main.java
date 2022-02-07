import player.Player;
import player.PlayerDAO;
import player.PlayerService;

public class Main {
    public static void main(String[] args) {

        PlayerDAO playerDAO = new PlayerDAO();
        PlayerService playerService = new PlayerService(playerDAO);

        for (Player p : playerDAO.getAllPlayers()) {
            System.out.println(p.toStringCSV());
        }

        System.out.println("---------------");

        playerService.findPlayerByFullName("Jonny wilkinson").wantsToExtendContract(2);
        playerService.findPlayerByFullName("Carlin isles").wantsToSwapShirts(3);




    }
}
