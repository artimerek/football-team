package pl.konradek.footballteam.converters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.konradek.footballteam.dto.PlayerDto;
import pl.konradek.footballteam.model.Player;
import pl.konradek.footballteam.service.TeamService;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DtoConverter {

    private final TeamService teamService;

    public PlayerDto playerToDto(Player player){
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(player.getId());
        playerDto.setName(player.getName());
        playerDto.setOvrl(player.getOvrl());
        playerDto.setTeam_id(player.getTeam().getId());
        return playerDto;
    }

    public Player dtoToPlayer(PlayerDto playerDto){
        Player player = new Player();
        player.setId(playerDto.getId());
        player.setName(playerDto.getName());
        player.setOvrl(playerDto.getOvrl());
        player.setTeam(teamService.findById(playerDto.getTeam_id()));
        return player;
    }

    public List<PlayerDto> playerToDto(List<Player> players){
        return players.stream()
                .map(this::playerToDto)
                .collect(Collectors.toList());
    }

    public List<Player> dtoToPlayer(List<PlayerDto> players){
        return players.stream()
                .map(this::dtoToPlayer)
                .collect(Collectors.toList());
    }

}
