package br.com.brunootavio.finance_track.controller;

import br.com.brunootavio.finance_track.model.Expense;
import br.com.brunootavio.finance_track.service.ExpenseService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@AllArgsConstructor
@Builder
public class ExpenseController {

    public final ExpenseService expenseService;

    @PostMapping
    public Expense save(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @GetMapping //endpoint get(buscar dados)
    public List<Expense> list() {
        return expenseService.allList();
    }
}
