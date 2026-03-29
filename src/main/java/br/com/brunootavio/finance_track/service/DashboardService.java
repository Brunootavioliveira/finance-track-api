package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.dto.CategorySummaryDTO;
import br.com.brunootavio.finance_track.dto.DashboardResponseDTO;
import br.com.brunootavio.finance_track.dto.TransactionDTO;
import br.com.brunootavio.finance_track.model.Expense;
import br.com.brunootavio.finance_track.model.Income;
import br.com.brunootavio.finance_track.model.User;
import br.com.brunootavio.finance_track.repository.ExpenseRepository;
import br.com.brunootavio.finance_track.repository.IncomeRepository;
import br.com.brunootavio.finance_track.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DashboardService {
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final SecurityService securityService;

    public DashboardService(IncomeRepository incomeRepository,
                            ExpenseRepository expenseRepository,
                            SecurityService securityService) {
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
        this.securityService = securityService;
    }

    public DashboardResponseDTO getDashboard() {

        User user = securityService.get();

        List<Income> incomes = incomeRepository.findByUser(user);
        List<Expense> expenses = expenseRepository.findByUser(user);

        BigDecimal totalIncome = incomes.stream()
                .map(Income::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpense = expenses.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balance = totalIncome.subtract(totalExpense);

        List<TransactionDTO> transactions = Stream.concat(
                        incomes.stream().map(i ->
                                new TransactionDTO(i.getDescription(), i.getAmount(), "INCOME", i.getDateTime())
                        ),
                        expenses.stream().map(e ->
                                new TransactionDTO(e.getDescription(), e.getAmount(), "EXPENSE", e.getDateTime())
                        )
                )
                .sorted(Comparator.comparing(TransactionDTO::dateTime).reversed())
                .limit(10)
                .collect(Collectors.toList());

        List<CategorySummaryDTO> expensesByCategory =
                expenseRepository.sumExpensesByCategory(user);
        return new DashboardResponseDTO(balance, totalIncome, totalExpense, transactions, expensesByCategory);
    }
    public List<CategorySummaryDTO> getExpensesByCategory(User user) {
        return expenseRepository.sumExpensesByCategory(user);
    }
}
