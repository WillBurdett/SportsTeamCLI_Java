package team;

import player.Player;

public class Team {
    private String name;
    private Player[] players;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
        this.players = new Player[15];
    }
}
