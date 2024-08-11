package com.zerobase.project5.domain.product.repository;

import com.zerobase.project5.domain.product.domain.OrganizationCode;
import com.zerobase.project5.domain.product.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {

    List<ProductInfo> findAllByOrgCd(OrganizationCode organizationCode);
}
