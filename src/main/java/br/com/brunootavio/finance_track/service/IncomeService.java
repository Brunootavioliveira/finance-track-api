package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.model.Income;
import br.com.brunootavio.finance_track.model.User;
import br.com.brunootavio.finance_track.repository.IncomeRepository;
import br.com.brunootavio.finance_track.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Builder
public class IncomeService {
    private final IncomeRepository incomeRepository;
    private final SecurityService securityService;

    public Income saveIncome(Income income) {
        User user = securityService.get();

        income.setUser(user);
        income.setDateTime(LocalDateTime.now());

        return incomeRepository.save(income);
    }

    public List<Income> listIncomeByUser() {
        User user = securityService.get();
        return incomeRepository.findByUser(user);
    }

    public void deleteIncome(Long id) {
        User user = securityService.get();

        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Income não encontrado"));

        if (!income.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Acesso negado");
        }

        incomeRepository.delete(income);
    }
}
