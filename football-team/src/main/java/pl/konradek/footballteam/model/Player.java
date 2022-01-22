package pl.konradek.footballteam.model;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer ovrl;
    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;


    public Player(Integer ovrl, String name) {
        this.ovrl = ovrl;
        this.name = name;
    }

    public Player() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOvrl() {
        return ovrl;
    }

    public void setOvrl(Integer ovrl) {
        this.ovrl = ovrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", ovrl=" + ovrl +
                ", name='" + name + '\'' +
                ", team=" + team +
                '}';
    }
}
