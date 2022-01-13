package pl.konradek.footballteam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.konradek.footballteam.datasource.Datasource;
import pl.konradek.footballteam.model.Player;
import pl.konradek.footballteam.service.PlayerService;
import pl.konradek.footballteam.service.TeamService;


@Controller
@RequestMapping("/players")
public class PlayersController {

    private final PlayerService playerService;
    private final TeamService teamService;

    public PlayersController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }


    @GetMapping("/all")
    public String getPlayers(Model model) {
        model.addAttribute("players", playerService.getPlayers());
        return "players";
    }

    @GetMapping("/player/{playerId}")
    public String getPlayerById(@PathVariable Integer playerId, Model model) {
        model.addAttribute("player", playerService.getPlayerById(playerId));
        return "player";
    }


    @GetMapping("/create-form")
    public String playerSubmit(Model model) {
        model.addAttribute("player", new Player());
        return "createPlayer";
    }

    @PostMapping("/create-form")
    public String playerForm(@ModelAttribute Player player, Model model) {

        if(player.getName().length() < 1) {
            System.out.println("Name is too short");
            return "transferResultFalse";
        }


        if(player.getOvrl() < 1|| player.getOvrl() > 99){
            System.out.println("Wrong ovrl given");
            return "transferResultFalse";
        }

        model.addAttribute("player", player);
        player.setId(Datasource.playersID++);
        playerService.addPlayer(player);
        teamService.addPlayerToTeam(player.getId(), 0);
        return "result-player";
    }
}
