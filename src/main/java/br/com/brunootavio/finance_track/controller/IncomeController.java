package br.com.brunootavio.finance_track.controller;

import br.com.brunootavio.finance_track.dto.IncomeRequestDTO;
import br.com.brunootavio.finance_track.dto.IncomeResponseDTO;
import br.com.brunootavio.finance_track.model.Income;
import br.com.brunootavio.finance_track.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<IncomeResponseDTO> create(@RequestBody IncomeRequestDTO dto) {

        Income income = Income.builder()
                .description(dto.description())
                .amount(dto.amount())
                .dateTime(dto.dateTime())
                .build();

        Income saved = incomeService.saveIncome(income);

        return ResponseEntity.status(201).body(new IncomeResponseDTO(
                saved.getId(),
                saved.getDescription(),
                saved.getAmount(),
                saved.getDateTime()
        ));
    }

    @GetMapping
    public ResponseEntity<List<IncomeResponseDTO>> list() {

        List<IncomeResponseDTO> response = incomeService.listIncomeByUser()
                .stream()
                .map(i -> new IncomeResponseDTO(
                        i.getId(),
                        i.getDescription(),
                        i.getAmount(),
                        i.getDateTime()
                ))
                .toList();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}") //DELETE /income/5
    public ResponseEntity<Void> delete(@PathVariable Long id) { //Pega o valor da URL, extrai e joga na variavel (id = 5)
        incomeService.deleteIncome(id);
        return  ResponseEntity.noContent().build();
    }
}
