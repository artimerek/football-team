package pl.konradek.footballteam.service;

import org.springframework.stereotype.Service;
import pl.konradek.footballteam.model.Player;
import pl.konradek.footballteam.model.Team;
import pl.konradek.footballteam.repository.PlayerRepository;
import pl.konradek.footballteam.repository.TeamRepository;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public TeamServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

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
}
