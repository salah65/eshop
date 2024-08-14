package edu.miu.cs.cs425.eshop.product.model;

import edu.miu.cs.cs425.eshop.category.model.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Table(name = "products")
@Entity()
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotBlank(message = "Name can't be blank")
    private String name;
    @NotNull()
    @NotBlank(message = "description can't be blank")
    private String description;
    @OneToMany
    private Set<Category> categories = new HashSet<>();

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
