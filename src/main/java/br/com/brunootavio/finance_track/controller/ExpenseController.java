package br.com.brunootavio.finance_track.controller;

import br.com.brunootavio.finance_track.dto.ExpenseResponseDTO;
import br.com.brunootavio.finance_track.model.Expense;
import br.com.brunootavio.finance_track.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@AllArgsConstructor
public class ExpenseController {

    public final ExpenseService expenseService;

    @PostMapping
    public Expense save(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    @GetMapping //endpoint get(buscar dados)
    public List<ExpenseResponseDTO> list() {
        return expenseService.allList()
                .stream()
                .map(expense -> new ExpenseResponseDTO(
                        expense.getId(),
                        expense.getDescription(),
                        expense.getAmount(),
                        expense.getDate()
                ))
                .toList();
    }
}
