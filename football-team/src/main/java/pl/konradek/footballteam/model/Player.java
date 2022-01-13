package pl.konradek.footballteam.model;



import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Player {
    private Integer id;

    private Integer ovrl;
    private String name;


    public Player(Integer id, Integer ovrl, String name) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", ovrl=" + ovrl +
                ", name='" + name + '\'' +
                '}';
    }
}
