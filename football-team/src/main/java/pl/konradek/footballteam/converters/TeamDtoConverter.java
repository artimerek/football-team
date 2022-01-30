package pl.konradek.footballteam.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.konradek.footballteam.dto.TeamDto;
import pl.konradek.footballteam.model.Team;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class TeamDtoConverter  {

    private final PlayerDtoConverter playerDtoConverter;
    public TeamDto entityToDto(Team team) {
        TeamDto teamDto = new TeamDto();
        teamDto.setId(team.getId());
        teamDto.setName(team.getName());
        teamDto.setPlayers(playerDtoConverter.entityToDto(team.getPlayers()));
        return teamDto;
    }

    public Team dtoToEntity(TeamDto teamDto) {
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setName(teamDto.getName());
        team.setPlayers(playerDtoConverter.dtoToEntity(teamDto.getPlayers()));
        return team;
    }

    public List<TeamDto> entityToDto(List<Team> list) {
        return list.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public List<Team> dtoToEntity(List<TeamDto> list) {
        return list.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());
    }
}
