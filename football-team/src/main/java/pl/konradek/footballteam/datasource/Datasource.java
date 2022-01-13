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
        this.players.add(new Player(playersID++, 85, "Waldemar"));
        this.players.add(new Player(playersID++, 69, "Szymon"));
        this.players.add(new Player(playersID++, 92, "Edward"));
        this.players.add(new Player(playersID++, 53, "Krzysztof"));
        this.players.add(new Player(playersID++, 73, "Materac"));
        this.players.add(new Player(playersID++, 43, "Banderola"));
        this.players.add(new Player(playersID++, 87, "Andrzej"));
        this.players.add(new Player(playersID++, 67, "Zbychu"));
        this.players.add(new Player(playersID++, 83, "Kamil"));

        Team team = new Team(teamsID++, "Free agents");


        Team team1 = new Team(teamsID++, "FC Ponalewce");

        team1.addPlayer(players.get(0));
        team1.addPlayer(players.get(1));
        team1.addPlayer(players.get(2));
        team1.addPlayer(players.get(3));

        Team team2 = new Team(teamsID++, "Odra Opole");

        team2.addPlayer(players.get(4));
        team2.addPlayer(players.get(5));
        team2.addPlayer(players.get(6));
        team2.addPlayer(players.get(7));
        team2.addPlayer(players.get(8));

        teams.add(team);
        teams.add(team1);
        teams.add(team2);
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
