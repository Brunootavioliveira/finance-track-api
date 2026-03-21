package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.model.Category;
import br.com.brunootavio.finance_track.model.User;
import br.com.brunootavio.finance_track.repository.CategoryRepository;
import br.com.brunootavio.finance_track.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final SecurityService securityService;
    private final CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        User user = securityService.get();

        if (categoryRepository.findByNameAndUser(category.getName(), user).isPresent()) {
            throw new RuntimeException("Você já tem uma categoria com esse nome!");
        }

        category.setUser(user);
        return categoryRepository.save(category);
    }

    public List<Category> listAll() {
        User user = securityService.get();
        return categoryRepository.findByUser(user);
    }
}
