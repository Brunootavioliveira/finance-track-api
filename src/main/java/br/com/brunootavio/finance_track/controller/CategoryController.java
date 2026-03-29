package br.com.brunootavio.finance_track.controller;

import br.com.brunootavio.finance_track.dto.CategoryRequestDTO;
import br.com.brunootavio.finance_track.dto.CategoryResponseDTO;
import br.com.brunootavio.finance_track.model.Category;
import br.com.brunootavio.finance_track.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.awt.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    public final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDTO createCategory(@RequestBody CategoryRequestDTO dto) {

        Category category = new Category();
        category.setName(dto.name());

        Category saved = categoryService.saveCategory(category);

        return new CategoryResponseDTO(
                saved.getId(),
                saved.getName()
        );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponseDTO> list() {

        return categoryService.listAll()
                .stream()
                .map(c -> new CategoryResponseDTO(
                        c.getId(),
                        c.getName()
                ))
                .toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();

    }
}
