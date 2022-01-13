package pl.konradek.footballteam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.konradek.footballteam.datasource.Datasource;
import pl.konradek.footballteam.model.Helper;
import pl.konradek.footballteam.model.Player;
import pl.konradek.footballteam.model.Team;
import pl.konradek.footballteam.service.PlayerService;
import pl.konradek.footballteam.service.TeamService;

import javax.validation.Valid;

@Controller
@RequestMapping("/teams")
public class TeamsController {

    private final TeamService teamService;
    private final PlayerService playerService;

    public TeamsController(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }


    @GetMapping("/all")
    public String getTeams(Model model) {
        model.addAttribute("teams", teamService.getTeams());
        return "teams";
    }

    @GetMapping("/team/{teamId}")
    public String getTeamById(@PathVariable Integer teamId, Model model) {
        model.addAttribute("team", teamService.getTeamById(teamId));
        return "team";
    }


    @GetMapping("/create-form")
    public String teamSubmit(Model model) {
        model.addAttribute("team", new Team());
        return "createTeam";
    }

    @PostMapping("/create-form")
    public String teamForm(@ModelAttribute Team team, Model model) {

        if(team.getName().length() < 1){
            return "teamRejected";
        }

        model.addAttribute("team", team);
        team.setId(Datasource.teamsID++);
        teamService.addTeam(team);
        return "result";
    }


    @GetMapping("/team/addPlayer")
    public String addPlayerToTheTeam(Model model) {
        model.addAttribute("helper", new Helper());
        return "transfer";
    }


    @PostMapping("/team/addPlayer")
    public String addPlayerToTheTeam(@Valid @ModelAttribute Helper helper, Model model) {
        teamService.addPlayerToTeam(helper.getPlayerID(), helper.getTeamID());

        Player player = playerService.getPlayerById(helper.getPlayerID());
        Team team = teamService.getTeamById(helper.getTeamID());


        if(player == null || team == null){
            return "transferResultFalse";
        }

        model.addAttribute("player", player);
        model.addAttribute("team", team);

        return "transferResult";
    }

}
