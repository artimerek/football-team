package pl.konradek.footballteam.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.konradek.footballteam.converters.TeamDtoConverter;
import pl.konradek.footballteam.dto.TeamDto;
import pl.konradek.footballteam.model.Team;
import pl.konradek.footballteam.service.TeamService;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestTeamsController {
    private final TeamService teamService;
    private final TeamDtoConverter dtoConverter;


    @GetMapping("/teams")
    List<TeamDto> findAll() {
        List<Team> teams = teamService.findAll();
        return dtoConverter.entityToDto(teams);
    }

    @GetMapping("/teams/{id}")
    public TeamDto getTeam(@PathVariable int id){
        Team team = teamService.findById(id);
        return dtoConverter.entityToDto(team);
    }

    @PostMapping("/teams")
    public TeamDto createTeam(@RequestBody Team team){
        Team team1 = new Team(team.getName());
        teamService.save(team1);
        return dtoConverter.entityToDto(team1);
    }

    @DeleteMapping("/teams/{id}")
    public void remove(@PathVariable int id){
        teamService.deleteById(id);
    }

}

