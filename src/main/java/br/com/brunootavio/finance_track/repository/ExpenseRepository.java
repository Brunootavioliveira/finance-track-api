package br.com.brunootavio.finance_track.repository;

import br.com.brunootavio.finance_track.dto.CategorySummaryDTO;
import br.com.brunootavio.finance_track.model.Expense;
import br.com.brunootavio.finance_track.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);
    Optional<Expense> findByIdAndUser(Long id, User user);
    @Query("""
    SELECT new br.com.brunootavio.finance_track.dto.CategorySummaryDTO(
        c.name,
        SUM(e.amount)
    )
    FROM Expense e
    JOIN e.category c
    WHERE e.user = :user
    GROUP BY c.name
""")
    List<CategorySummaryDTO> sumExpensesByCategory(@Param("user") User user);
}
