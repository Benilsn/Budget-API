package com.varejonline.budget.Budget.repositories;

import com.varejonline.budget.Budget.models.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {


}
