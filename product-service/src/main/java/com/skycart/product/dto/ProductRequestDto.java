package com.skycart.product.dto;

import java.math.BigDecimal;

public class ProductRequestDto {

	private Long categoryId;

    private String name;

    private String brand;

    private String description;

    private String packSize;

    private BigDecimal price;

    private Integer stockQty;

    private Integer lowStockThreshold;

    private String imageUrl;
    
    public Long getCategoryId() {
 		return categoryId;
 	}

 	public void setCategoryId(Long categoryId) {
 		this.categoryId = categoryId;
 	}

 	public String getName() {
 		return name;
 	}

 	public void setName(String name) {
 		this.name = name;
 	}

 	public String getBrand() {
 		return brand;
 	}

 	public void setBrand(String brand) {
 		this.brand = brand;
 	}

 	public String getDescription() {
 		return description;
 	}

 	public void setDescription(String description) {
 		this.description = description;
 	}

 	public String getPackSize() {
 		return packSize;
 	}

 	public void setPackSize(String packSize) {
 		this.packSize = packSize;
 	}

 	public BigDecimal getPrice() {
 		return price;
 	}

 	public void setPrice(BigDecimal price) {
 		this.price = price;
 	}
}