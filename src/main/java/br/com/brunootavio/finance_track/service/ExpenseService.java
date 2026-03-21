package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.model.Category;
import br.com.brunootavio.finance_track.model.Expense;
import br.com.brunootavio.finance_track.model.Income;
import br.com.brunootavio.finance_track.model.User;
import br.com.brunootavio.finance_track.repository.CategoryRepository;
import br.com.brunootavio.finance_track.repository.ExpenseRepository;
import br.com.brunootavio.finance_track.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService{

    public final UserRepository userRepository;
    public final SecurityService securityService;
    public final ExpenseRepository expenseRepository;
    public final CategoryRepository categoryRepository;

    public Expense createExpense(Expense expense, Long categoryId) {

        User user = securityService.get();

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        if(!category.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Categoria não pertence ao usuário");
        }

        expense.setUser(user); //Associa a despesa (expense) ao usuário logado.
        expense.setCategory(category);
        expense.setDateTime(LocalDateTime.now());

        return  expenseRepository.save(expense);
    }

    public List<Expense> allList() {

        User user = securityService.get();

        return expenseRepository.findByUser(user);
    }

    public void deleteExpense(Long id) {
        User user = securityService.get();

        Expense expense = expenseRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Expense não encontrado"));

        expenseRepository.delete(expense);
    }
}
