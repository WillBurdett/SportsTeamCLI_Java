package player;

import player.Player;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
    List<Player> allPlayers = new ArrayList<>();

    public List<Player> getAllPlayers() {

        Player carlin = new Player("Carlin Isles", "Wing", 14, LocalDate.of(2022,05,01));
        Player jonny = new Player("Jonny Wilkinson", "Fly Half", 10, LocalDate.of(2022,04,01));

        allPlayers.add(carlin);
        allPlayers.add(jonny);

        return allPlayers;
    }

}
