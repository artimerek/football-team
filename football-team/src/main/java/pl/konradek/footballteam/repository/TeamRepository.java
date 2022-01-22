package pl.konradek.footballteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.konradek.footballteam.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
