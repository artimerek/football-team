package pl.konradek.footballteam.service;

import pl.konradek.footballteam.model.Team;

import java.util.List;

public interface TeamService {

     void addPlayerToTeam(int playerId, int teamId);

    List<Team> findAll();

    Team getById(Integer teamId);

    void save(Team team);

    Team findById(Integer teamID);
}
