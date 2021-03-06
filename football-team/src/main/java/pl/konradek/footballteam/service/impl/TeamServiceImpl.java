package pl.konradek.footballteam.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.konradek.footballteam.model.Player;
import pl.konradek.footballteam.model.Team;
import pl.konradek.footballteam.repository.PlayerRepository;
import pl.konradek.footballteam.repository.TeamRepository;
import pl.konradek.footballteam.service.TeamService;

import java.util.List;

@AllArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;


    public void addPlayerToTeam(int playerId, int teamId){
        Team team = teamRepository.getById(teamId);
        Player player = playerRepository.getById(playerId);

        Team oldTeam = player.getTeam();

        if(oldTeam != null) {
            oldTeam.removePlayer(player);
        }

        player.setTeam(team);
        playerRepository.save(player);

    }

    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    public Team getById(Integer teamId) {
        return teamRepository.getById(teamId);
    }

    public void save(Team team) {
        teamRepository.save(team);
    }

    public Team findById(Integer teamID) {
        return teamRepository.findById(teamID).orElse(null);
    }

    @Override
    public void deleteById(Integer teamId) {
        teamRepository.deleteById(teamId);
    }
}
