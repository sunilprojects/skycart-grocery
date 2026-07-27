package com.skycart.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skycart.product.dto.CategoryRequestDto;
import com.skycart.product.dto.CategoryResponseDto;
import com.skycart.product.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@PostMapping
	public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto request) {
		return categoryService.createCategory(request);
	}
	
	  @GetMapping
	    public List<CategoryResponseDto> getAllCategories() {

	        return categoryService.getAllCategories();
	    }

	    @GetMapping("/{id}")
	    public CategoryResponseDto getCategory(
	            @PathVariable Long id) {

	        return categoryService.getCategory(id);
	    }

	    @PutMapping("/{id}")
	    public CategoryResponseDto updateCategory(
	            @PathVariable Long id,
	            @RequestBody CategoryRequestDto request) {

	        return categoryService.updateCategory(id, request);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCategory(
	            @PathVariable Long id) {

	        categoryService.deleteCategory(id);
	    }

}
