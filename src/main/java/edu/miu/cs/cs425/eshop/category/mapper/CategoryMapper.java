package edu.miu.cs.cs425.eshop.category.mapper;

import edu.miu.cs.cs425.eshop.category.dto.CategoryRequest;
import edu.miu.cs.cs425.eshop.category.dto.CategoryResponse;
import edu.miu.cs.cs425.eshop.category.model.Category;
import edu.miu.cs.cs425.eshop.core.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper implements Mapper<Category, CategoryRequest, CategoryResponse> {
    @Override
    public CategoryResponse mapToResponse(Category product) {
        return new CategoryResponse(product.getId(), product.getName());
    }

    @Override
    public Category mapToDomain(CategoryRequest categoryRequest) {
        return new Category(categoryRequest.getName());
    }

    @Override
    public List<CategoryResponse> mapToResponses(List<Category> products) {
        return products.stream().map((category) -> new CategoryResponse(
                category.getId(), category.getName())).toList();

    }
}
