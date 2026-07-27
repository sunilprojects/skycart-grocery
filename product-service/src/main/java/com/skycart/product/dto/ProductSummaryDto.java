package com.skycart.product.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductSummaryDto {

    private Long id;

    private String name;

    private String brand;

    private String packSize;

    private BigDecimal price;

    private boolean outOfStock;

    private boolean lowStock;
}