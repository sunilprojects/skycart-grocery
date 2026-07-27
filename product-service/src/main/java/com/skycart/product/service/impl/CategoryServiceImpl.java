package com.skycart.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skycart.product.dto.CategoryRequestDto;
import com.skycart.product.dto.CategoryResponseDto;
import com.skycart.product.mapper.CategoryMapper;
import com.skycart.product.model.Category;
import com.skycart.product.repository.CategoryRepository;
import com.skycart.product.service.CategoryService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	

	@Override
	public CategoryResponseDto createCategory(CategoryRequestDto request) {
		 
		Category category=categoryMapper.toEntity(request);
		   Category saved=categoryRepository.save(category);
		   
		   
		return categoryMapper.toResponseDto(saved);
	}
	
    @Override
    public List<CategoryResponseDto> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponseDto)
                .toList();
    }
    
    @Override
    public CategoryResponseDto getCategory(
            Long categoryId) {

        Category category =
                categoryRepository.findById(categoryId)
                .orElseThrow();

        return categoryMapper.toResponseDto(category);
    }
    
    @Override
    @Transactional
    public CategoryResponseDto updateCategory(
            Long categoryId,
            CategoryRequestDto request) {

        Category category =
                categoryRepository.findById(categoryId)
                .orElseThrow();

        category.setName(request.getName());
        category.setDescription(
                request.getDescription());

        return categoryMapper.toResponseDto(category);
    }
    
    @Override
    @Transactional
    public void deleteCategory(
            Long categoryId) {

        Category category =
                categoryRepository.findById(categoryId)
                .orElseThrow();

        // Soft Delete
        category.setActive(false);
    }

}
