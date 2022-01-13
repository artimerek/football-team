package pl.konradek.footballteam.service;

import pl.konradek.footballteam.model.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getPlayers();

    Player getPlayerById(Integer id);

    void addPlayer(Player player);
}
