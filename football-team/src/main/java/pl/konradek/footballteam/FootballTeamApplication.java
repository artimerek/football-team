package pl.konradek.footballteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class FootballTeamApplication {

    //  TODO Create player validation -> name not empty longer than 1 character + ovrl in range 1 -> 99 , same with team creator

    public static void main(String[] args) {
        SpringApplication.run(FootballTeamApplication.class, args);
    }

}
