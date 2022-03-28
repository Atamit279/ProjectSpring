package tech.das.springproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.das.springproject.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
