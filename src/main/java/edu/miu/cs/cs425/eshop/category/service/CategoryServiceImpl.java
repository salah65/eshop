package edu.miu.cs.cs425.eshop.category.service;

import edu.miu.cs.cs425.eshop.category.model.Category;
import edu.miu.cs.cs425.eshop.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category product) {
        categoryRepository.save(product);
        return categoryRepository.findById(product.getId().longValue()).orElseThrow();
    }

    @Override
    public Category getCategoryById(Integer id) throws NoSuchElementException {
       return categoryRepository.findById(id.longValue()).orElseThrow();
    }

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }
}
