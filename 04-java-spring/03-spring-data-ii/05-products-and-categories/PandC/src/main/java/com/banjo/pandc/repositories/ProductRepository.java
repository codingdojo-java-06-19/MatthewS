package com.banjo.pandc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banjo.pandc.models.Category;
import com.banjo.pandc.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}
