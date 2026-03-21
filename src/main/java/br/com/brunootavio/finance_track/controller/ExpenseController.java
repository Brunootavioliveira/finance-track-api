package br.com.brunootavio.finance_track.controller;

import br.com.brunootavio.finance_track.dto.ExpenseRequestDTO;
import br.com.brunootavio.finance_track.dto.ExpenseResponseDTO;
import br.com.brunootavio.finance_track.model.Expense;
import br.com.brunootavio.finance_track.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@AllArgsConstructor
public class ExpenseController {

    public final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseResponseDTO> save(@RequestBody ExpenseRequestDTO dto) { //resposta completa http

        Expense expense = new Expense();
        expense.setDescription(dto.description());
        expense.setAmount(dto.amount());

        Expense saved = expenseService.createExpense(expense, dto.categoryId());

        return ResponseEntity.status(201).body(new ExpenseResponseDTO(
                saved.getId(),
                saved.getDescription(),
                saved.getAmount(),
                saved.getDateTime(),
                saved.getCategory().getName()
        ));
    }

    @GetMapping //endpoint get(buscar dados)
    public List<ExpenseResponseDTO> list() {
        return expenseService.allList()
                .stream()
                .map(expense -> new ExpenseResponseDTO(
                        expense.getId(),
                        expense.getDescription(),
                        expense.getAmount(),
                        expense.getDateTime(),
                        expense.getCategory().getName()
                ))
                .toList();
    }

    @DeleteMapping("/{id}") //DELETE /income/5
    public ResponseEntity<Void> delete(@PathVariable Long id) { //Pega o valor da URL, extrai e joga na variavel (id = 5)
        expenseService.deleteExpense(id);
        return  ResponseEntity.noContent().build();
    }
}
