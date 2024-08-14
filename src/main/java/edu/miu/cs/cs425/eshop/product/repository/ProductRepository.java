package edu.miu.cs.cs425.eshop.product.repository;

import edu.miu.cs.cs425.eshop.product.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
