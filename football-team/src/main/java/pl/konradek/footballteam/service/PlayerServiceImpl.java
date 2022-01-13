package pl.konradek.footballteam.service;

import org.springframework.stereotype.Service;
import pl.konradek.footballteam.datasource.Datasource;
import pl.konradek.footballteam.model.Player;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final Datasource datasource;

    public PlayerServiceImpl(Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public List<Player> getPlayers() {
        return datasource.getPlayers();
    }


    @Override
    public Player getPlayerById(Integer id) {
        try {
            return datasource.getPlayerById(id);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void addPlayer(Player player) {
        datasource.addPlayer(player);
    }


}
