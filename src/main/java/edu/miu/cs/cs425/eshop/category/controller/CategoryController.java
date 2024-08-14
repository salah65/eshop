package edu.miu.cs.cs425.eshop.category.controller;

import edu.miu.cs.cs425.eshop.category.dto.CategoryRequest;
import edu.miu.cs.cs425.eshop.category.dto.CategoryResponse;
import edu.miu.cs.cs425.eshop.category.mapper.CategoryMapper;
import edu.miu.cs.cs425.eshop.category.model.Category;
import edu.miu.cs.cs425.eshop.category.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("eshop/api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        Category newCategory = categoryMapper.mapToDomain(categoryRequest);
        Category category = categoryService.createCategory(newCategory);
        return ResponseEntity.ok(categoryMapper.mapToResponse(category));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllProducts() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryMapper.mapToResponses(categories));
    }

    @GetMapping(params = "categoryId")
    public ResponseEntity<CategoryResponse> getProductById(@Valid @RequestParam("categoryId") Integer id) {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryMapper.mapToResponse(category));
    }
}
