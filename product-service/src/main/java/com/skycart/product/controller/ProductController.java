package com.skycart.product.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skycart.product.dto.ProductRequestDto;
import com.skycart.product.dto.ProductResponseDto;
import com.skycart.product.dto.ProductSummaryDto;
import com.skycart.product.dto.StockUpdateDto;
import com.skycart.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductSummaryDto> getProducts(
            @RequestParam(required = false)
            Long categoryId,

            @RequestParam(required = false)
            String keyword,

            @PageableDefault(size = 20)
            Pageable pageable) {

        return productService.getProducts(
                categoryId,
                keyword,
                pageable);
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProduct(
            @PathVariable Long id) {

        return productService.getProduct(id);
    }

    @PostMapping
    public ProductResponseDto createProduct(
            @RequestBody ProductRequestDto request) {

        return productService.createProduct(request);
    }

    @PutMapping("/{id}")
    public ProductResponseDto updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequestDto request) {

        return productService.updateProduct(
                id,
                request);
    }

    @PatchMapping("/{id}/stock")
    public void updateStock(
            @PathVariable Long id,
            @RequestBody StockUpdateDto request) {

        productService.updateStock(
                id,
                request.getStockQty());
    }

    @DeleteMapping("/{id}")
    public void deactivateProduct(
            @PathVariable Long id) {

        productService.deactivateProduct(id);
    }
}