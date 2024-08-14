package edu.miu.cs.cs425.eshop.category.model;

import edu.miu.cs.cs425.eshop.product.model.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Table(name = "categories")
@Entity()
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotBlank(message = "Name can't be blank")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categories")
    private List<Product> product;

    public Category(String name) {
        this.name = name;
    }
}
