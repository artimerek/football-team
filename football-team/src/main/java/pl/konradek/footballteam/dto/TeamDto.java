package pl.konradek.footballteam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class TeamDto {
    private Integer id;
    private String name;
    private List<PlayerDto> players;
}
