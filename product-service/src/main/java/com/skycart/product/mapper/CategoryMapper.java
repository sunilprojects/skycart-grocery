package com.skycart.product.mapper;

import org.springframework.stereotype.Component;

import com.skycart.product.dto.CategoryRequestDto;
import com.skycart.product.dto.CategoryResponseDto;
import com.skycart.product.model.Category;

@Component
public class CategoryMapper {
	public Category toEntity(
            CategoryRequestDto dto) {

        Category category = new Category();

        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        return category;
    }

    public CategoryResponseDto toResponseDto(
            Category category) {

        CategoryResponseDto dto =
                new CategoryResponseDto();

        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setActive(category.isActive());

        return dto;
    }

}
