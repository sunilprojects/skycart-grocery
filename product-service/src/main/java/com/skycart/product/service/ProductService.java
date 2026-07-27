package com.skycart.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skycart.product.dto.ProductRequestDto;
import com.skycart.product.dto.ProductResponseDto;
import com.skycart.product.dto.ProductSummaryDto;


public interface ProductService {

    Page<ProductSummaryDto> getProducts(
            Long categoryId,
            String keyword,
            Pageable pageable);

    ProductResponseDto getProduct(Long productId);

    ProductResponseDto createProduct(
            ProductRequestDto request);

    ProductResponseDto updateProduct(
            Long productId,
            ProductRequestDto request);

    void updateStock(
            Long productId,
            Integer stockQty);

    void deactivateProduct(Long productId);
}
