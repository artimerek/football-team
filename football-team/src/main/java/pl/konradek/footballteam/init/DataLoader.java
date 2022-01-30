package pl.konradek.footballteam.init;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.konradek.footballteam.model.Player;
import pl.konradek.footballteam.model.Team;
import pl.konradek.footballteam.service.impl.PlayerServiceImpl;
import pl.konradek.footballteam.service.impl.TeamServiceImpl;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final TeamServiceImpl teamService;
    private final PlayerServiceImpl playerService;

    public void run(ApplicationArguments args) {
        teamService.save(new Team("Free agents"));
        teamService.save(new Team("FC Ponalewce"));
        teamService.save(new Team("Odra Opole"));

        Player player = new Player(85, "Waldemar");
        player.setTeam(teamService.getById(3));
        playerService.save(player);
        player = new Player(69, "Szymon");
        playerService.save(player);
        player.setTeam(teamService.getById(3));
        playerService.save(player);
        player = new Player(92, "Edward");
        player.setTeam(teamService.getById(2));
        playerService.save(player);
        player = new Player(53, "Krzysztof");
        player.setTeam(teamService.getById(3));
        playerService.save(player);
        player = new Player(73, "Materac");
        player.setTeam(teamService.getById(2));
        playerService.save(player);
        player = new Player(43, "Banderola");
        player.setTeam(teamService.getById(3));
        playerService.save(player);
        player = new Player(87, "Andrzej");
        player.setTeam(teamService.getById(3));
        playerService.save(player);
        player = new Player(67, "Zbychu");
        player.setTeam(teamService.getById(2));
        playerService.save(player);
        player = new Player(83, "Kamil");
        player.setTeam(teamService.getById(2));
        playerService.save(player);

    }
}