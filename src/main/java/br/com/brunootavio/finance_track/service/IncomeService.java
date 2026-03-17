package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.model.Income;
import br.com.brunootavio.finance_track.model.User;
import br.com.brunootavio.finance_track.repository.IncomeRepository;
import br.com.brunootavio.finance_track.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Builder
public class IncomeService {

    public final IncomeRepository incomeRepository;
    public final UserRepository userRepository;

    public Income saveIncome(Income income, Long userId) { //criar uma receita atrelada ao ususario
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        income.setUser(user);
        return incomeRepository.save(income);
    }

    //listar as receitas
    public List<Income> listIncomeByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return incomeRepository.findByUser(user);
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
