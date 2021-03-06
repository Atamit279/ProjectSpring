package tech.das.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.das.springproject.entities.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository <Account, Integer> {
    Optional<Account> findAccountByLogin(String login);
}
