package br.com.brunootavio.finance_track.repository;

import br.com.brunootavio.finance_track.model.Expense;
import br.com.brunootavio.finance_track.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);
}
