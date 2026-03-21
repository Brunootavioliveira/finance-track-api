package br.com.brunootavio.finance_track.controller;

import br.com.brunootavio.finance_track.dto.CategoryRequestDTO;
import br.com.brunootavio.finance_track.dto.CategoryResponseDTO;
import br.com.brunootavio.finance_track.model.Category;
import br.com.brunootavio.finance_track.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.awt.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    public final CategoryService categoryService;

    @PostMapping
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
    public List<CategoryResponseDTO> list() {

        return categoryService.listAll()
                .stream()
                .map(c -> new CategoryResponseDTO(
                        c.getId(),
                        c.getName()
                ))
                .toList();
    }
}
