package edu.miu.cs.cs425.eshop.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
}
