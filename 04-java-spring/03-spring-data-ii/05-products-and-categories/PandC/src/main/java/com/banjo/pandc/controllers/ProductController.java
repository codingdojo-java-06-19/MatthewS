package com.banjo.pandc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banjo.pandc.models.Category;
import com.banjo.pandc.models.Product;
import com.banjo.pandc.services.CategoryServices;
import com.banjo.pandc.services.ProductServices;

@Controller
@RequestMapping("/products")
public class ProductController {
	private final ProductServices productService;
	private final CategoryServices categoryService;
	
	private ProductController(ProductServices productService, CategoryServices categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/new")
	public String newProd(@ModelAttribute("product") Product product, Model model) {
		return "newProd.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addProd(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		System.out.println("We made it");
		if (result.hasErrors()) {
			System.out.println(result);
			return "redirect:/new";
		} else {
			System.out.println("Success");
			productService.createProduct(product);
			return "redirect:/products/" + product.getId();
		}
	}
	
	@RequestMapping("/{id}")
	public String displayProd(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		List<Category> uniqueCats = categoryService.findWithoutProduct(product);
		model.addAttribute("uniqueCats", uniqueCats);
		List<Category> addedCats = product.getCategories();
		model.addAttribute("addedCat", addedCats);
		return "showProd.jsp";
	}
	
	@RequestMapping(value="/addCategory/{id}", method=RequestMethod.POST)
	public String addCatToProd(@RequestParam("category") Long category_id, @PathVariable("id") Long product_id) {
		System.out.println(category_id);
		System.out.println(product_id);
		productService.addCategoryToProduct(product_id, category_id);
		return "redirect:/products/" + product_id;
	}
	
}
