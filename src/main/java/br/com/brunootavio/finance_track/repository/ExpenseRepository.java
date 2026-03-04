package br.com.brunootavio.finance_track.repository;

import br.com.brunootavio.finance_track.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
