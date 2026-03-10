package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.model.Expense;
import br.com.brunootavio.finance_track.model.User;
import br.com.brunootavio.finance_track.repository.ExpenseRepository;
import br.com.brunootavio.finance_track.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService{

    public final UserRepository userRepository;
    public final ExpenseRepository expenseRepository;

    public Expense createExpense(Expense expense) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // retorna o contexto de segurança da sessão atual. E pega os detalhes da autenticação (quem está logado, roles...

        String email = authentication.getName(); //retorna o identificador do usuário, que nesse caso é o email

        User user = userRepository.findByEmail(email) //Se o usuário existir, ele é armazenado na variável user.
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        expense.setUser(user); //Associa a despesa (expense) ao usuário logado.
        expense.setDate(LocalDateTime.now());

        return  expenseRepository.save(expense);
    }

    public List<Expense> allList() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return expenseRepository.findByUser(user);
    }

}
