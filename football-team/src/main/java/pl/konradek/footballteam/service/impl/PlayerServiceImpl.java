package pl.konradek.footballteam.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.konradek.footballteam.model.Player;
import pl.konradek.footballteam.repository.PlayerRepository;
import pl.konradek.footballteam.service.PlayerService;

import java.util.List;

@AllArgsConstructor
@Repository
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public Player findById(Integer playerID) {
        return playerRepository.findById(playerID).orElse(null);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player getById(Integer playerId) {
        return playerRepository.getById(playerId);
    }

    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void deleteById(Integer playerId) {
        playerRepository.deleteById(playerId);
    }
}
