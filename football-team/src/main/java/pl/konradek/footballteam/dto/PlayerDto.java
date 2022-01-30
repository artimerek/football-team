package pl.konradek.footballteam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PlayerDto {
    private Integer id;
    private Integer ovrl;
    private String name;
    private int team_id;

}
