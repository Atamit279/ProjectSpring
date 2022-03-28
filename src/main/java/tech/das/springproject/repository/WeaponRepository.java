package tech.das.springproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.das.springproject.entities.Weapon;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}
