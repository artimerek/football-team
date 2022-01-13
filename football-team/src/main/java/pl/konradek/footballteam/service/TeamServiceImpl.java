package pl.konradek.footballteam.service;

import org.springframework.stereotype.Service;
import pl.konradek.footballteam.datasource.Datasource;
import pl.konradek.footballteam.model.Team;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final Datasource datasource;

    public TeamServiceImpl(Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public List<Team> getTeams() {
        return datasource.getTeams();
    }

    @Override
    public Team getTeamById(Integer id) {
        try {
            return datasource.getTeamById(id);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addTeam(Team team) {
        datasource.addTeam(team);
    }

    @Override
    public void addPlayerToTeam(Integer playerId, Integer teamId) {
        try {
            datasource.addPlayerToTeam(playerId, teamId);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
