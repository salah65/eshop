package edu.miu.cs.cs425.eshop.category.service;

import edu.miu.cs.cs425.eshop.category.model.Category;

import java.util.List;

public interface CategoryService {
     Category createCategory(Category product);
     Category getCategoryById(Integer id);
     List<Category> getAllCategories();
}
