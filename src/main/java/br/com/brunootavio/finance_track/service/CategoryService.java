package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.model.Category;
import br.com.brunootavio.finance_track.model.User;
import br.com.brunootavio.finance_track.repository.CategoryRepository;
import br.com.brunootavio.finance_track.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final UserRepository userRepository;
    private  final CategoryRepository categoryRepository;

    public Category saveCategory(Category category, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        if(categoryRepository.findByNameAndUser(category.getName(),user).isPresent()) {
            throw new RuntimeException("Você ja tem uma categoria com esse nome!");
        }

        category.setUser(user); //casar a categoria escrita pelo usuario com a conta do usuario
        return categoryRepository.save(category);
    }

    public List<Category> listAll (Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        return categoryRepository.findByUser(user); //listar para o usuario da conta só suas categorias
    }
}
