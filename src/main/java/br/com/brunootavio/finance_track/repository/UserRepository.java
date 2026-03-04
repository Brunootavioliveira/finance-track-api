package br.com.brunootavio.finance_track.repository;

import br.com.brunootavio.finance_track.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
