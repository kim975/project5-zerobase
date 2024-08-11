package com.zerobase.project5.domain.product.repository;

import com.zerobase.project5.domain.product.domain.OrganizationCode;
import com.zerobase.project5.domain.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrgCd(OrganizationCode organizationCode);
}
