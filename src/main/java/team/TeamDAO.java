package team;

import java.util.ArrayList;
import java.util.List;

public class TeamDAO {

    List <Team> allTeams = new ArrayList<>();

    public List<Team> getAllTeams() {

        Team england = new Team("England");
        Team scotland = new Team("Scotland");

        allTeams.add(england);
        allTeams.add(scotland);

        return allTeams;
    }
}
