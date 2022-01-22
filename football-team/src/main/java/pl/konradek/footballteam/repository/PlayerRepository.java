package pl.konradek.footballteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.konradek.footballteam.model.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
