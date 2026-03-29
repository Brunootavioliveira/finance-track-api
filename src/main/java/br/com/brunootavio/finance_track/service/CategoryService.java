package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.exception.BusinessException;
import br.com.brunootavio.finance_track.exception.ResouceNotFoundException;
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
            throw new BusinessException("Você já tem uma categoria com esse nome!");
        }

        category.setUser(user);
        return categoryRepository.save(category);
    }

    public List<Category> listAll() {
        User user = securityService.get();
        return categoryRepository.findByUser(user);
    }

    public Category deleteCategory(Long id) {
        User user = securityService.get();

        Category category = categoryRepository.findByIdAndUser(id, user)
                .orElseThrow(()-> new ResouceNotFoundException("Categoria não encontrada!"));

        categoryRepository.delete(category);
        return category;
    }
}
