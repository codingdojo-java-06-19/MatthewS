package com.banjo.pandc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banjo.pandc.models.Category;
import com.banjo.pandc.models.Product;
import com.banjo.pandc.repositories.CategoryRepository;
import com.banjo.pandc.repositories.ProductRepository;

@Service
public class CategoryServices {
	private final CategoryRepository cRepo;
	private final ProductRepository pRepo;
	
	public CategoryServices(CategoryRepository cRepo, ProductRepository pRepo) {
		this.cRepo = cRepo;
		this.pRepo = pRepo;
	}
	
	public List<Category> allCategories(){
		return cRepo.findAll();
	}
	
	public Category createCategory(Category c) {
		return cRepo.save(c);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = cRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public List<Category> findWithoutProduct(Product product){
		return cRepo.findByProductsNotContains(product);
	}
	
	//Retrieve Categories that are not added to the product
	public List<Category> catsNotAdded(Product product){
		return cRepo.findByProductsNotContains(product);
	}
	
	public void addProductToCategory(Category category, Product product) {
		category.addProduct(product);
		createCategory(category);
	}
	
	public void addProductToCategory(Long category_id, Long product_id) {
		Category category = findCategory(category_id);
		Product product = pRepo.findById(product_id).orElse(null);
		addProductToCategory(category, product);
	}
}
