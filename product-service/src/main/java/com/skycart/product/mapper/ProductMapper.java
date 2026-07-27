package com.skycart.product.mapper;

import org.springframework.stereotype.Component;

import com.skycart.product.dto.ProductRequestDto;
import com.skycart.product.dto.ProductResponseDto;
import com.skycart.product.dto.ProductSummaryDto;
import com.skycart.product.model.Product;

@Component
public class ProductMapper {
	
	 public ProductResponseDto toResponseDto(
	            Product product) {

	        ProductResponseDto dto =
	                new ProductResponseDto();

	        dto.setId(product.getId());
	        dto.setName(product.getName());
	        dto.setPrice(product.getPrice());
	       

	        return dto;
	    }
	 
	 //updating the product
	 public void updateEntity(Product product, ProductRequestDto request) {
		    product.setName(request.getName());
		    product.setBrand(request.getBrand());
		    product.setPackSize(request.getPackSize());
		    product.setPrice(request.getPrice());
		    product.setDescription(request.getDescription());
		 
	 }
	 
	 // here creating product object
	 public Product toEntity(
		        ProductRequestDto request) {

		    Product product = new Product();

		    product.setName(request.getName());
		    product.setBrand(request.getBrand());
		    product.setPrice(request.getPrice());
		    product.setPackSize(request.getPackSize());
		    product.setDescription(request.getDescription());

		    return product;
		}
	 
	 public ProductSummaryDto toSummaryDto(Product product) {
		 ProductSummaryDto dto =
		            new ProductSummaryDto();

		    dto.setId(product.getId());
		    dto.setName(product.getName());
		    dto.setBrand(product.getBrand());
		    dto.setPackSize(product.getPackSize());
		    dto.setPrice(product.getPrice());

		    dto.setOutOfStock(product.isOutOfStock());
		    dto.setLowStock(product.isLowStock());

		    return dto;
		}

}
