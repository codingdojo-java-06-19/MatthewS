package com.banjo.pandc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banjo.pandc.models.Category;
import com.banjo.pandc.models.Product;
import com.banjo.pandc.repositories.CategoryRepository;
import com.banjo.pandc.repositories.ProductRepository;

@Service
public class ProductServices {
	private final ProductRepository pRepo;
	private final CategoryRepository cRepo;
	
	public ProductServices(ProductRepository pRepo, CategoryRepository cRepo) {
		this.pRepo = pRepo;
		this.cRepo = cRepo;
	}
	
	public List<Product> allProducts(){
		return pRepo.findAll();
	}
	
	public Product createProduct(Product p) {
		return pRepo.save(p);
	}
	
	public List<Product> getUniqueCats(Category category) {
		return pRepo.findByCategoriesNotContains(category);
	}	

	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = pRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public void addCategoryToProduct(Category category, Product product) {
		product.addCategory(category);
		createProduct(product);
	}
	
	public void addCategoryToProduct(Long product_id, Long category_id) {
		Product product = findProduct(product_id);
		Category category = cRepo.findById(category_id).orElse(null);
		addCategoryToProduct(category, product);
		
	}
}
