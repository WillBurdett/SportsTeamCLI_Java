package player;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {

    private PlayerDAO playerDAO;

    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
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
}
