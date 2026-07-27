package com.skycart.product.service;

import java.util.List;

import com.skycart.product.dto.CategoryRequestDto;
import com.skycart.product.dto.CategoryResponseDto;

public interface CategoryService {
	
	CategoryResponseDto createCategory(CategoryRequestDto request);
	List<CategoryResponseDto>getAllCategories();
	CategoryResponseDto getCategory(Long categoryId);
	CategoryResponseDto updateCategory( Long categoryId, CategoryRequestDto request);
	void deleteCategory(Long categoryId);

}
