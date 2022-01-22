package pl.konradek.footballteam.service;

import pl.konradek.footballteam.model.Player;

import java.util.List;

public interface PlayerService {

     Player findById(Integer playerID);

     List<Player> findAll();

     Player getById(Integer playerId);

     void save(Player player);
}
