package com.skycart.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skycart.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByActiveTrue(Pageable pageable);

    Page<Product> findByCategoryIdAndActiveTrue(
            Long categoryId,
            Pageable pageable);

    @Query("""
            SELECT p
            FROM Product p
            WHERE p.active = true
            AND (
                lower(p.name) LIKE lower(concat('%',:keyword,'%'))
                OR
                lower(p.brand) LIKE lower(concat('%',:keyword,'%'))
            )
            """)
    Page<Product> searchProducts(
            @Param("keyword") String keyword,
            Pageable pageable);
}