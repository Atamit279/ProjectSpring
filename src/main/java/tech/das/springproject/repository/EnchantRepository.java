package tech.das.springproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.das.springproject.entities.Enchant;

@Repository
public interface EnchantRepository extends JpaRepository<Enchant, Long> {
}
