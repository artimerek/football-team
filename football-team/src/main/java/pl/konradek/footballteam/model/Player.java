package pl.konradek.footballteam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Player  {

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
}
