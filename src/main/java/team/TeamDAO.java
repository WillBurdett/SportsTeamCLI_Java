package team;

import java.util.ArrayList;
import java.util.List;

public class TeamDAO {



    public List<Team> getAllTeams() {

        List <Team> allTeams = new ArrayList<>();

        Team england = new Team("England");
        Team scotland = new Team("Scotland");

        allTeams.add(england);
        allTeams.add(scotland);

        return allTeams;
    }

    public void saveAllTeams(){
        System.out.println("Saving teams...");
        System.out.println("Teams saved");
    }
}
