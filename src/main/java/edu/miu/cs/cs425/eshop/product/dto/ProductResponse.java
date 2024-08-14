package edu.miu.cs.cs425.eshop.product.dto;

import edu.miu.cs.cs425.eshop.category.dto.CategoryResponse;
import edu.miu.cs.cs425.eshop.category.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private Category category;
}
