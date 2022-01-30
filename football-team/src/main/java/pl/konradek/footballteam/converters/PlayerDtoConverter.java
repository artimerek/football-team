package pl.konradek.footballteam.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.konradek.footballteam.dto.PlayerDto;
import pl.konradek.footballteam.model.Player;
import pl.konradek.footballteam.service.TeamService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PlayerDtoConverter {

    private final TeamService teamService;

    public PlayerDto entityToDto(Player player) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(player.getId());
        playerDto.setName(player.getName());
        playerDto.setOvrl(player.getOvrl());
        playerDto.setTeam_id(player.getTeam().getId());
        return playerDto;
    }

    public Player dtoToEntity(PlayerDto playerDto) {
        Player player = new Player();
        player.setId(playerDto.getId());
        player.setName(playerDto.getName());
        player.setOvrl(playerDto.getOvrl());
        player.setTeam(teamService.findById(playerDto.getTeam_id()));
        return player;
    }

    public List<PlayerDto> entityToDto(List<Player> list) {
        return list.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public List<Player> dtoToEntity(List<PlayerDto> list) {
        return list.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());
    }
}
