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
@RequestMapping("/categories")
public class CategoryController {
	private final CategoryServices categoryService;
	private final ProductServices productService;
	
	public CategoryController(CategoryServices categoryService, ProductServices productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@RequestMapping("/new")
	public String addCat(@ModelAttribute("category") Category category) {
		return "newCat.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		System.out.println("We made it");
		if (result.hasErrors()) {
			System.out.println("result has errors");
			return "redirect:/new";
		} else {
			System.out.println("Success");
			categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@RequestMapping("/{id}")
	public String displayCat(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		List<Product> products = category.getProducts();
		model.addAttribute("category", category);
		model.addAttribute("products", products);
		List<Product> unAdded = productService.getUniqueCats(category);
		model.addAttribute("unAdded", unAdded);
		return "showCat.jsp";
	}
	
	@RequestMapping("/addProduct/{id}")
	public String addProd(@RequestParam("product") Long product_id, @PathVariable("id") Long category_id) {
		categoryService.addProductToCategory(category_id, product_id);
		return "redirect:/categories/" + category_id;
	}
}
