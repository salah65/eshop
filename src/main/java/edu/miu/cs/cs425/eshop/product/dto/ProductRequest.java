package edu.miu.cs.cs425.eshop.product.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private Integer categoryId;
}
