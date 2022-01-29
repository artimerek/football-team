package pl.konradek.footballteam.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.konradek.footballteam.converters.DtoConverter;
import pl.konradek.footballteam.dto.PlayerDto;
import pl.konradek.footballteam.model.Player;
import pl.konradek.footballteam.service.PlayerService;
import pl.konradek.footballteam.service.TeamService;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestPlayersController {

    private final PlayerService playerService;
    private final TeamService teamService;
    private final DtoConverter dtoConverter;


    @GetMapping("/players")
    List<PlayerDto> findAll() {
        List<Player> players = playerService.findAll();
        return dtoConverter.playerToDto(players);
    }

    @GetMapping("/players/{id}")
    public PlayerDto getPlayer(@PathVariable int id){
        Player player = playerService.findById(id);
        return dtoConverter.playerToDto(player);
    }

    @PostMapping("/players")
    public PlayerDto createPlayer(@RequestBody Player player){
        Player player1 = new Player(player.getOvrl(), player.getName());
        player1.setTeam(teamService.getById(1));
        playerService.save(player1);

        return dtoConverter.playerToDto(player);
    }

    @DeleteMapping("/players/{id}")
    public void remove(@PathVariable int id){
        playerService.deleteById(id);
    }

}
