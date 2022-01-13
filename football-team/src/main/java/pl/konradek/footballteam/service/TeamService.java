package pl.konradek.footballteam.service;

import pl.konradek.footballteam.model.Team;

import java.util.List;

public interface TeamService {

    List<Team> getTeams();

    Team getTeamById(Integer id);

    void addTeam(Team team);

    void addPlayerToTeam(Integer playerId, Integer teamId);


}
