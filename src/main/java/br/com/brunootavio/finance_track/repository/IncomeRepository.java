package br.com.brunootavio.finance_track.repository;

import br.com.brunootavio.finance_track.model.Income;
import br.com.brunootavio.finance_track.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByUser(User user);

    //buscar receitas por descricao
    List<Income> findByDescriptionContainingIgnoreCaseAndUser(String description, User user);
}
