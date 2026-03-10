package br.com.brunootavio.finance_track.repository;

import br.com.brunootavio.finance_track.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email); //optional pq o usuario pode nao existir
}
