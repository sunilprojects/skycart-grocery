package com.skycart.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skycart.product.dto.ProductRequestDto;
import com.skycart.product.dto.ProductResponseDto;
import com.skycart.product.dto.ProductSummaryDto;
import com.skycart.product.mapper.ProductMapper;
import com.skycart.product.model.Category;
import com.skycart.product.model.Product;
import com.skycart.product.repository.CategoryRepository;
import com.skycart.product.repository.ProductRepository;
import com.skycart.product.service.ProductService;

import jakarta.transaction.Transactional;

@Service
public  class ProductServiceImpl implements ProductService {
	
	 private final ProductRepository productRepository;
	 private final CategoryRepository categoryRepository;
	 private final ProductMapper productMapper;
	 
	 public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository,ProductMapper productMapper) {
		 this.productRepository=productRepository;
		 this.categoryRepository=categoryRepository;
		 this.productMapper=productMapper;
	 }
	 

	
	@Override
	public Page<ProductSummaryDto> getProducts(
	        Long categoryId,
	        String keyword,
	        Pageable pageable) {

	    Page<Product> products;

	    if(categoryId != null){

	        products = productRepository
	                .findByCategoryIdAndActiveTrue(
	                        categoryId,
	                        pageable);

	    } else if(keyword != null &&
	            !keyword.isBlank()) {

	        products = productRepository
	                .searchProducts(
	                        keyword,
	                        pageable);

	    } else {

	        products = productRepository
	                .findByActiveTrue(pageable);
	    }

	    return products.map(productMapper::toSummaryDto);
	}
	
	//create products
	@Override
	@Transactional
	public ProductResponseDto createProduct(
	        ProductRequestDto request) {

	    Category category =
	            categoryRepository.findById(
	                    request.getCategoryId())
	            .orElseThrow();

	    Product product = productMapper.toEntity(request);

	    product.setCategory(category);

	    Product saved =
	            productRepository.save(product);

	    return productMapper.toResponseDto(saved);
	}
	
	//update products
	
	@Override
	@Transactional
	public ProductResponseDto updateProduct(
	        Long productId,
	        ProductRequestDto request) {

	    Product product =
	            productRepository.findById(productId)
	            .orElseThrow();

	    productMapper.updateEntity(product,request);

     return productMapper.toResponseDto(product);
	}
	
	//update stock
	@Override
	@Transactional
	public void updateStock(
	        Long productId,
	        Integer stockQty) {

	    Product product =
	            productRepository.findById(productId)
	            .orElseThrow();

	    product.setStockQty(stockQty);
	}
	
	//delete product
	@Override
	@Transactional
	public void deactivateProduct(
	        Long productId) {

	    Product product =
	            productRepository.findById(productId)
	            .orElseThrow();

	    product.setActive(false);
	}



	@Override
	public ProductResponseDto getProduct(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
