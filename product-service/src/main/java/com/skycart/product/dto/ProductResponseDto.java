package com.skycart.product.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductResponseDto {

    private Long id;

    private Long categoryId;

    private String categoryName;

    private String name;

    private String brand;

    private String description;

    private String packSize;

    private BigDecimal price;

    private Integer stockQty;

    private Integer lowStockThreshold;

    private String imageUrl;

    private boolean active;

    private boolean outOfStock;

    private boolean lowStock;
}
