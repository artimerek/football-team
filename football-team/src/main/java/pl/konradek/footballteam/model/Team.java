package pl.konradek.footballteam.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}
