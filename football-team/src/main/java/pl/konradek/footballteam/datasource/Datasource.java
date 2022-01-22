package pl.konradek.footballteam.datasource;

import org.springframework.stereotype.Component;
import pl.konradek.footballteam.model.Player;
import pl.konradek.footballteam.model.Team;

import java.util.ArrayList;
import java.util.List;

@Component
public class Datasource {
    private final List<Player> players = new ArrayList<>();
    private final List<Team> teams = new ArrayList<>();

    public static Integer playersID = 0;
    public static Integer teamsID = 0;


    public Datasource() {

    }


    public Player getPlayerById(int playerId) {
        if(!checkPlayer(playerId)){
            throw new IllegalArgumentException("Wrong player id given");
        }

        return players.stream()
                .filter(player -> player.getId() == playerId)
                .findAny()
                .orElse(null);
    }

    public Team getTeamById(int teamId) {

       if(!checkTeam(teamId)){
            throw new IllegalArgumentException("Wrong team id given");
        }

        return teams.stream()
                .filter(player -> player.getId() == teamId)
                .findAny()
                .orElse(null);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addPlayerToTeam(Integer playerId, Integer teamId) {

        if(!checkPlayer(playerId) || !checkTeam(teamId)){
            throw new IllegalArgumentException("Wrong player id given");
        }

        Player player = getPlayerById(playerId);
        Team team = getTeamById(teamId);

        Team team2 = null;

        for (Team team1 : teams) {
            for (Player player1 : team1.getPlayers()) {
                if (player1.getId().equals(playerId)) {
                    team2 = team1;
                    break;
                }
            }
        }

        if (team2 != null) {
            team2.removePlayer(player);
        }

        team.addPlayer(player);
    }

    private boolean checkPlayer(Integer playerID){
        return players.stream()
                .anyMatch(player -> player.getId().equals(playerID));
    }

    private boolean checkTeam(Integer teamID){
        return teams.stream()
                .anyMatch(team -> team.getId().equals(teamID));
    }

}
