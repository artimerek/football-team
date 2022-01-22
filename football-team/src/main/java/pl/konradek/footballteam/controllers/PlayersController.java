package pl.konradek.footballteam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.konradek.footballteam.model.Player;
import pl.konradek.footballteam.service.PlayerService;
import pl.konradek.footballteam.service.impl.PlayerServiceImpl;
import pl.konradek.footballteam.service.TeamService;
import pl.konradek.footballteam.service.impl.TeamServiceImpl;


@Controller
@RequestMapping("/players")
public class PlayersController {


    private final PlayerService playerService;

    private final TeamService teamService;

    public PlayersController(PlayerServiceImpl playerService, TeamServiceImpl teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @GetMapping("/all")
    public String getPlayers(Model model) {
        model.addAttribute("players", playerService.findAll());
        return "players";
    }

    @GetMapping("/player/{playerId}")
    public String getPlayerById(@PathVariable Integer playerId, Model model) {
        model.addAttribute("player", playerService.getById(playerId));
        return "player";
    }


    @GetMapping("/create-form")
    public String playerSubmit(Model model) {
        model.addAttribute("player", new Player());
        return "createPlayer";
    }

    @PostMapping("/create-form")
    public String playerForm(@ModelAttribute Player player) {

        if(player.getName().length() < 1) {
            System.out.println("Name is too short");
            return "transferResultFalse";
        }

        if(player.getOvrl() < 1|| player.getOvrl() > 99){
            System.out.println("Wrong ovrl given");
            return "transferResultFalse";
        }

        player.setTeam(teamService.getById(1));
        playerService.save(player);

        return "result-player";
    }
}
