package com.zerobase.project5.domain.product.repository;

import com.zerobase.project5.domain.product.domain.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductListRepository extends JpaRepository<ProductList, Long> {
}
