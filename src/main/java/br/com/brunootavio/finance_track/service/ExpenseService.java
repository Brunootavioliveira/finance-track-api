package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.model.Expense;
import br.com.brunootavio.finance_track.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
@Builder
public class ExpenseService{

    public final ExpenseRepository expenseRepository;

    public Expense save(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> allList() {
        return expenseRepository.findAll();
    }
}
