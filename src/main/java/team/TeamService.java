package team;

import player.PlayerDAO;

public class TeamService {
    private PlayerDAO playerDAO;
    private TeamDAO teamDAO;

    public TeamService(PlayerDAO playerDAO, TeamDAO teamDAO) {
        this.playerDAO = playerDAO;
        this.teamDAO = teamDAO;
    }
}
