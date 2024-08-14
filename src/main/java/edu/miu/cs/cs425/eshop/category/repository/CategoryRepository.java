package edu.miu.cs.cs425.eshop.category.repository;

import edu.miu.cs.cs425.eshop.category.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
