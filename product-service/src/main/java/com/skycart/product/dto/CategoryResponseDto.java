package com.skycart.product.dto;

import lombok.Data;

@Data
public class CategoryResponseDto {
	private Long id;
    private String name;
    private String description;
    private boolean active;

}
